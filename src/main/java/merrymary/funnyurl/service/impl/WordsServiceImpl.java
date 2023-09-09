package merrymary.funnyurl.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import merrymary.funnyurl.dto.WordDto;
import merrymary.funnyurl.exception.WordExistException;
import merrymary.funnyurl.mapper.WordsMapper;
import merrymary.funnyurl.model.Word;
import merrymary.funnyurl.repository.WordRepository;
import merrymary.funnyurl.service.WordsService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@Slf4j
@RequiredArgsConstructor
public class WordsServiceImpl implements WordsService {
    private final WordRepository repository;

    @Override
    public String addWords(WordDto wordDto, Model model) {
        Word word = WordsMapper.toWord(wordDto);
        try {
            repository.save(word);
        } catch (RuntimeException e) {
            String error = e.getMessage();
            String constraint = "uq_word_name";
            if (error.contains(constraint)) {
                error = String.format("Word %s already exists", wordDto.getName());
                throw new WordExistException(error);
            }
            throw new RuntimeException("Ошибка при передаче данных в БД");
        }
        return "addWordsResultOK";
    }

    @Override
    public String freeExpiredWords() {
        return "page";
    }
}
