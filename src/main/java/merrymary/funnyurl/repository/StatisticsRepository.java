package merrymary.funnyurl.repository;

import merrymary.funnyurl.model.Hit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends JpaRepository<Hit, Long> {

}
