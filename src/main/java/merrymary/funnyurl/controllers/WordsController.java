package merrymary.funnyurl.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import merrymary.funnyurl.dto.WordDto;
import merrymary.funnyurl.service.WordsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/words")
@Slf4j
@RequiredArgsConstructor
public class WordsController {
    private final WordsService service;

    @GetMapping
    public String getWordsPage(Model model) {
        return "addWords";
    }

    @PostMapping
    public String addWords(@Valid @ModelAttribute WordDto word, Model model) {
        return service.addWords(word, model);
    }

    @PatchMapping("/free")
    public String freeExpiredWords() {
        return service.freeExpiredWords();
    }

}
