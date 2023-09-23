package merrymary.funnyurl.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class HitDto implements Comparable<HitDto> {
    String url;
    long views;

    @Override
    public int compareTo(HitDto o) {
        return Long.compare(o.getViews(), views);
    }
}
