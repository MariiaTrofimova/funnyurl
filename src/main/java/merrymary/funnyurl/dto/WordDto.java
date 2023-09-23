package merrymary.funnyurl.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class WordDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
