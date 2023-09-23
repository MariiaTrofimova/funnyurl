package merrymary.funnyurl.mapper;

import merrymary.funnyurl.dto.UrlInDto;
import merrymary.funnyurl.model.Url;
import merrymary.funnyurl.model.Word;

public class UrlMapper {
    public static Url toUrl(UrlInDto urlInDto, Word word) {
        Url url = new Url();
        url.setLongUrl(urlInDto.getLongUrl());
        url.setWord(word);
        return url;
    }
}
