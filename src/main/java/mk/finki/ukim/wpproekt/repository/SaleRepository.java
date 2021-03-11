package mk.finki.ukim.wpproekt.repository;

import mk.finki.ukim.wpproekt.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
