package merrymary.funnyurl.repository;

import merrymary.funnyurl.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    Word findFirstByFreeTrue();

    Word findWordByName(String name);
}
