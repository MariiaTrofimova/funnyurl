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
    private String name;
    private String description;
    private String example;
    private boolean isFree;
}
