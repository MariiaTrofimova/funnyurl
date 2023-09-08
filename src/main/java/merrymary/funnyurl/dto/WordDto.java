package merrymary.funnyurl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class WordDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String example;
}
