package merrymary.funnyurl.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import merrymary.funnyurl.dto.WordDto;
import merrymary.funnyurl.service.WordsService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController("/admin/words")
@Slf4j
@RequiredArgsConstructor
public class WordsController {
    private final WordsService service;

    @PostMapping
    public boolean addWords(@RequestBody @Valid List<WordDto> words){
        return service.addWords(words);
    }

    @PatchMapping
    public boolean freeExpiredWords() {
        return service.freeExpiredWords();
    }

}
