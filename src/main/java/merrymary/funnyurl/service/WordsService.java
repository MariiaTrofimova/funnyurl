package merrymary.funnyurl.service;

import merrymary.funnyurl.dto.WordDto;
import merrymary.funnyurl.model.Word;

import java.util.List;

public interface WordsService {
    boolean addWords(List<WordDto> words);

    boolean freeExpiredWords();
}
