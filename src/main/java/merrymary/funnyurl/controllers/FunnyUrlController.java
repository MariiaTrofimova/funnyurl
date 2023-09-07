package merrymary.funnyurl.controllers;

import merrymary.funnyurl.dto.UrlInDto;
import merrymary.funnyurl.dto.UrlOutDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@RestController
@RequestMapping
public class FunnyUrlController {

    @PostMapping("/app")
    @ResponseStatus(HttpStatus.CREATED)
    public UrlOutDto add(@Valid @RequestBody UrlInDto urlInDto) {
        return null;
    }

    @GetMapping("/{shortUrl}")
    @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    public RedirectView get(@PathVariable String shortUrl, RedirectAttributes attributes) {
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        //server: поиск нужной ссылки, запись статистики просмотров
        return new RedirectView("https://ya.ru/");
    }
}
