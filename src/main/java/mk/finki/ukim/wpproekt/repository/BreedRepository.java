package mk.finki.ukim.wpproekt.repository;

import mk.finki.ukim.wpproekt.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedRepository extends JpaRepository<Breed, Long> {
}
