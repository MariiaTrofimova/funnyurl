package merrymary.funnyurl.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import merrymary.funnyurl.dto.UrlInDto;
import merrymary.funnyurl.exception.NotFoundException;
import merrymary.funnyurl.service.FunnyUrlService;
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
@Slf4j
@RequiredArgsConstructor
public class FunnyUrlController {
    private final FunnyUrlService service;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@Valid @ModelAttribute UrlInDto urlInDto, HttpServletRequest request, Model model) {
        String ip = request.getRemoteAddr();
        return service.addUrl(urlInDto, ip, model);
    }

    @GetMapping("/{shortUrl}")
    @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    public RedirectView get(@PathVariable String shortUrl, RedirectAttributes attributes, HttpServletRequest request) {
        if (!shortUrl.chars().allMatch(Character::isLetter)) {
            throw new NotFoundException("Link contains non letter characters");
        }
        String ip = request.getRemoteAddr();
        return service.getLongUrl(shortUrl, attributes, ip);
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
