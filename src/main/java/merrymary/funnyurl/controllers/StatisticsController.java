package merrymary.funnyurl.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import merrymary.funnyurl.service.StatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Controller
@RequestMapping("/admin/statistics")
@Slf4j
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsService service;

    @GetMapping
    public String getTop(@PositiveOrZero(message = "Индекс первого элемента не может быть отрицательным")
                         @RequestParam(defaultValue = "0") Integer from,
                         @Positive(message = "Количество элементов для отображения должно быть положительным")
                         @RequestParam(defaultValue = "10") Integer size,
                         Model model) {
        return service.getTop(from, size, model);
    }

}
