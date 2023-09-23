package merrymary.funnyurl.service;

import merrymary.funnyurl.dto.WordDto;
import org.springframework.ui.Model;

public interface WordsService {
    String addWords(WordDto word, Model model);

    String freeExpiredWords();
}
