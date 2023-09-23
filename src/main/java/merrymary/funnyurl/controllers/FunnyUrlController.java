package merrymary.funnyurl.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import merrymary.funnyurl.dto.UrlInDto;
import merrymary.funnyurl.dto.WordDto;
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
    private static final String PREFIX = "http://localhost:8080/";


    private final FunnyUrlService service;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@Valid @ModelAttribute UrlInDto urlInDto, HttpServletRequest request, Model model) {
        String ip = request.getRemoteAddr();

        WordDto wordDto = service.addUrl(urlInDto, ip);
        model.addAttribute("shortUrl", PREFIX + wordDto.getName());
        model.addAttribute("word", wordDto.getName());
        model.addAttribute("description", wordDto.getDescription());
        model.addAttribute("longUrl", urlInDto.getLongUrl());

        return "result";
    }

    @GetMapping("/{shortUrl}")
    @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    public RedirectView get(@PathVariable String shortUrl, RedirectAttributes attributes, HttpServletRequest request) {
        if (!shortUrl.chars().allMatch(Character::isLetter)) {
            throw new NotFoundException("Link contains non letter characters");
        }
        String ip = request.getRemoteAddr();

        attributes.addFlashAttribute("flashAttribute", "redirectedFromFunnyUrls");
        attributes.addAttribute("attribute", "redirectedFromFunnyUrls");

        String longUrl = service.getLongUrl(shortUrl, ip);

        return new RedirectView(longUrl);
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
