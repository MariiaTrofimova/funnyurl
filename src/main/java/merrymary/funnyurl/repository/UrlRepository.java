package merrymary.funnyurl.repository;

import merrymary.funnyurl.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long>, CrudRepository<Url, Long> {
}
