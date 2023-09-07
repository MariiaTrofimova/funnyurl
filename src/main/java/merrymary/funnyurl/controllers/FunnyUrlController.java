package merrymary.funnyurl.controllers;

import merrymary.funnyurl.dto.UrlInDto;
import merrymary.funnyurl.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping
public class FunnyUrlController {

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@Valid @ModelAttribute UrlInDto urlInDto) {
        return "index";
    }

    @GetMapping("/{shortUrl}")
    @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    public RedirectView get(@PathVariable String shortUrl, RedirectAttributes attributes, HttpServletRequest request) {
        if (!shortUrl.chars().allMatch(Character::isLetter)) {
            throw new NotFoundException("Помотушта");
        }
        String ip = request.getRemoteAddr();
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        //server: поиск нужной ссылки, запись статистики просмотров
        //public static boolean isAlpha(String s) {
        //        return s != null && s.chars().allMatch(Character::isLetter);
        //    }
        return new RedirectView("https://ya.ru/");
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
