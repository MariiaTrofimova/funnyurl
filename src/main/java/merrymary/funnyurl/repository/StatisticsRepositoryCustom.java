package merrymary.funnyurl.repository;

import java.util.Map;

public interface StatisticsRepositoryCustom {
    Map<Long, Long> getUniqueViews(int from, int size);
}
