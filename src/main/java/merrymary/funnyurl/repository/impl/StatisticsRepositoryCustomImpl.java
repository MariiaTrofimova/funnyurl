package merrymary.funnyurl.repository.impl;

import lombok.RequiredArgsConstructor;
import merrymary.funnyurl.repository.StatisticsRepositoryCustom;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StatisticsRepositoryCustomImpl implements StatisticsRepositoryCustom {
    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public Map<Long, Long> getUniqueViews(int from, int size) {
        String sql = "select url_id, COUNT(DISTINCT(ip)) as views from hits " +
                "group by url_id " +
                "order by views " +
                " limit :size offset :from";
        final Map<Long, Long> hitsQtyByUrlId = new HashMap<>();
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("from", from);
        parameters.addValue("size", size);
        namedJdbcTemplate.query(sql, parameters,
                rs -> {
                    long appId = rs.getLong("url_id");
                    long views = rs.getLong("views");
                    hitsQtyByUrlId.put(appId, views);
                });
        return hitsQtyByUrlId;
    }
}
