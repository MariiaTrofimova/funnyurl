package merrymary.funnyurl.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import merrymary.funnyurl.dto.UrlInDto;
import merrymary.funnyurl.repository.UrlRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Service
@Slf4j
@RequiredArgsConstructor
public class FunnyUrlServiceImpl implements FunnyUrlService{
    private final UrlRepository repository;

    @Override
    public RedirectView getLongUrl(String shortUrl, RedirectAttributes attributes, String ip) {
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        //server: поиск нужной ссылки, запись статистики просмотров
        //public static boolean isAlpha(String s) {
        //        return s != null && s.chars().allMatch(Character::isLetter);
        //    }
        return null;
    }

    @Override
    public String addUrl(UrlInDto urlInDto, String ip) {
        return null;
    }
}
