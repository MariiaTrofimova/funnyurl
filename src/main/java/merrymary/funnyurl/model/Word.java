package merrymary.funnyurl.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "words")
@Getter
@Setter
@ToString
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "is_free")
    private boolean isFree;
}
