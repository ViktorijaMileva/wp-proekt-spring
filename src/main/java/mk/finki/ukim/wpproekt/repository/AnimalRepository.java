package mk.finki.ukim.wpproekt.repository;

import mk.finki.ukim.wpproekt.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
