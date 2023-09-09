package merrymary.funnyurl.mapper;

import merrymary.funnyurl.dto.WordDto;
import merrymary.funnyurl.model.Word;

public class WordsMapper {
    public static Word toWord(WordDto wordDto) {
        Word word = new Word();
        word.setName(wordDto.getName().strip().toLowerCase());
        word.setDescription(wordDto.getDescription().strip().toLowerCase());
        word.setFree(true);
        return word;
    }

    public static WordDto toWordDto (Word word) {
        return WordDto.builder()
                .name(word.getName())
                .description(word.getDescription())
                .build();
    }
}
