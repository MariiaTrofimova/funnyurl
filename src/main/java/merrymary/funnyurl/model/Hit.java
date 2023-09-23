package merrymary.funnyurl.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "hits")
@Getter
@Setter
@ToString
public class Hit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "url_id")
    private Url url;
    @Column(name = "ip")
    private String ip;
    @Column(name = "timestamp")
    @CreationTimestamp
    private Instant timestamp;
}