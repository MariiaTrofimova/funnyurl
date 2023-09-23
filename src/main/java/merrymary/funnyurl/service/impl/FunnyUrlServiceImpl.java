package merrymary.funnyurl.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import merrymary.funnyurl.dto.UrlInDto;
import merrymary.funnyurl.dto.WordDto;
import merrymary.funnyurl.exception.NotFoundException;
import merrymary.funnyurl.mapper.UrlMapper;
import merrymary.funnyurl.mapper.WordsMapper;
import merrymary.funnyurl.model.Hit;
import merrymary.funnyurl.model.Url;
import merrymary.funnyurl.model.Word;
import merrymary.funnyurl.repository.StatisticsRepository;
import merrymary.funnyurl.repository.UrlRepository;
import merrymary.funnyurl.repository.WordRepository;
import merrymary.funnyurl.service.FunnyUrlService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FunnyUrlServiceImpl implements FunnyUrlService {

    private final UrlRepository repository;
    private final WordRepository wordRepo;
    private final StatisticsRepository statsRepo;

    @Override
    public String getLongUrl(String shortUrl, String ip) {
        Word word = wordRepo.findWordByName(shortUrl);

        Url url = repository.findByWordId(word.getId());

        Hit hit = new Hit();
        hit.setUrl(url);
        hit.setIp(ip);
        statsRepo.save(hit);
        log.info("Ip {} watched link {} with word {}", ip, url.getId(), word.getName());

        return url.getLongUrl();
    }

    @Override
    public WordDto addUrl(UrlInDto urlInDto, String ip) {
        PageRequest page = PageRequest.of(0, 1);
        List<Word> words = wordRepo.findFree(page).getContent();
        if (words.isEmpty()) {
            log.warn("All words are busy");
            throw new NotFoundException("All words are busy, ask anybody to add words");
        }
        Word word = words.get(0);
        Url url = UrlMapper.toUrl(urlInDto, word);
        repository.save(url);
        log.info("url {} refers to word {}. Saved by ip {}", url.getId(), word.getName(), ip);
        return WordsMapper.toWordDto(word);
    }
}