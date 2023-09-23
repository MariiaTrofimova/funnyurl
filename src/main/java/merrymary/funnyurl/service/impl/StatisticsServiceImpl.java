package merrymary.funnyurl.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import merrymary.funnyurl.dto.HitDto;
import merrymary.funnyurl.model.Url;
import merrymary.funnyurl.repository.StatisticsRepositoryCustom;
import merrymary.funnyurl.repository.UrlRepository;
import merrymary.funnyurl.service.StatisticsService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticsServiceImpl implements StatisticsService {
    private final StatisticsRepositoryCustom repository;
    private final UrlRepository urlRepo;

    @Override
    public String getTop(int from, int size, Model model) {
        Map<Long, Long> hitsByUrlId = repository.getUniqueViews(from, size);
        List<Url> urls = urlRepo.findByIdIn(new ArrayList<>(hitsByUrlId.keySet()));
        List<HitDto> hitDto = urls.stream()
                .map(url -> HitDto.builder()
                        .url(url.getLongUrl())
                        .views(hitsByUrlId.get(url.getId()))
                        .build())
                .sorted()
                .collect(Collectors.toList());
        StringBuilder list = new StringBuilder();
        IntStream.range(0, hitDto.size())
                .forEach(i -> list.append(i)
                        .append(" ")
                        .append(hitDto.get(i).getUrl())
                        .append(" -----> ")
                        .append(hitDto.get(i).getViews())
                        .append(" unique views"));
        hitDto.forEach(h -> list.append(h.getUrl()).append("----->").append(h.getViews()).append(" unique views"));
        model.addAttribute("topHead", "Top " + hitDto.size());
        model.addAttribute("topList", list.toString());
        return "topStatistics";
    }
}
