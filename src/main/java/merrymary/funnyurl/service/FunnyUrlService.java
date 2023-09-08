package merrymary.funnyurl.service;

import merrymary.funnyurl.dto.UrlInDto;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

public interface FunnyUrlService {

    RedirectView getLongUrl(String shortUrl, RedirectAttributes attributes, String ip);

    String addUrl(UrlInDto urlInDto, String ip, Model model);
}
