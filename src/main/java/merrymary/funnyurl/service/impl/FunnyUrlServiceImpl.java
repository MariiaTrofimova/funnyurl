package merrymary.funnyurl.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import merrymary.funnyurl.dto.UrlInDto;
import merrymary.funnyurl.model.Word;
import merrymary.funnyurl.repository.UrlRepository;
import merrymary.funnyurl.service.FunnyUrlService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Service
@Slf4j
@RequiredArgsConstructor
public class FunnyUrlServiceImpl implements FunnyUrlService {
    private static final String PREFIX = "http://localhost:8080/";

    private final UrlRepository repository;

    @Override
    public RedirectView getLongUrl(String shortUrl, RedirectAttributes attributes, String ip) {
        attributes.addFlashAttribute("flashAttribute", "redirectedFromFunnyUrls");
        attributes.addAttribute("attribute", "redirectedFromFunnyUrls");
        //server: поиск нужной ссылки, запись статистики просмотров
        //public static boolean isAlpha(String s) {
        //        return s != null && s.chars().allMatch(Character::isLetter);
        //    }
        return new RedirectView("https://ya.ru");
    }

    @Override
    public String addUrl(UrlInDto urlInDto, String ip, Model model) {
        Word word = new Word();
        word.setName("cattywampus");
        word.setDescription("The word cattywampus is most commonly used in the USA, especially the southern states. It is a word which refers to something that is misaligned.");
        word.setExample("The bank is cattywampus from the park.");
        model.addAttribute("shortUrl", PREFIX + word.getName());
        model.addAttribute("word", word.getName());
        model.addAttribute("description", word.getDescription());
        model.addAttribute("example", word.getExample());
        model.addAttribute("longUrl", urlInDto.getLongUrl());
        return "result";
    }
}
