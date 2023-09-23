package merrymary.funnyurl.service;

import merrymary.funnyurl.dto.UrlInDto;
import merrymary.funnyurl.dto.WordDto;

public interface FunnyUrlService {

    String getLongUrl(String shortUrl, String ip);

    WordDto addUrl(UrlInDto urlInDto, String ip);
}
