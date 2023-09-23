package merrymary.funnyurl.repository;

import merrymary.funnyurl.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    List<Url> findByIdIn(List<Long> ids);

    Url findByWordId(long wordId);
}
