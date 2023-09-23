package merrymary.funnyurl.repository;

import merrymary.funnyurl.model.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query("select w from Word w " +
            "where w.isFree=true")
    Page<Word> findFree(Pageable page);

    Word findWordByName(String name);
}
