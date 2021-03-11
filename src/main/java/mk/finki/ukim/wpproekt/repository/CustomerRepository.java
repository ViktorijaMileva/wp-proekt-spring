package mk.finki.ukim.wpproekt.repository;

import mk.finki.ukim.wpproekt.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
