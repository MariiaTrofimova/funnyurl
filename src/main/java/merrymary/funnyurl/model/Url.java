package merrymary.funnyurl.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "urls")
@Getter
@Setter
@ToString
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "long_url")
    private String longUrl;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id")
    private Word word;
    @Column(name = "created")
    @CreationTimestamp
    private Instant created;
}
