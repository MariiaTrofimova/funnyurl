package merrymary.funnyurl.service.impl;

import merrymary.funnyurl.dto.WordDto;
import merrymary.funnyurl.service.WordsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordsServiceImpl implements WordsService {
    @Override
    public boolean addWords(List<WordDto> words) {
        return false;
    }

    @Override
    public boolean freeExpiredWords() {
        return false;
    }
}
