package merrymary.funnyurl.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Url {

    @Id
    private Long id;
    private String longUrl;
    private String shortUrl;
    private Instant expireDate;
}
