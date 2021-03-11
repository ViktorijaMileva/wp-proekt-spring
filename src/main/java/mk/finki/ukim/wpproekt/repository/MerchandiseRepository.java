package mk.finki.ukim.wpproekt.repository;

import mk.finki.ukim.wpproekt.model.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchandiseRepository extends JpaRepository<Merchandise, Long> {
}
