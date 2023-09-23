package merrymary.funnyurl.service;

import org.springframework.ui.Model;

public interface StatisticsService {
    String getTop(int from, int size, Model model);
}
