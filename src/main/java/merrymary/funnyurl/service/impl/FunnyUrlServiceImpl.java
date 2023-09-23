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
import org.springframework.stereotype.Service;

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
        Word word = wordRepo.findFirstByFreeTrue();
        if (word == null) {
            log.warn("All words are busy");
            throw new NotFoundException("All words are busy, ask anybody to add words");
        }
        Url url = UrlMapper.toUrl(urlInDto, word);
        repository.save(url);
        log.info("url {} refers to word {}. Saved by ip {}", url.getId(), word.getName(), ip);
        return WordsMapper.toWordDto(word);
    }
}