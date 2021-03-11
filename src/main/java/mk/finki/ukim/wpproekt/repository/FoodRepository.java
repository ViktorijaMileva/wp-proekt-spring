package mk.finki.ukim.wpproekt.repository;

import mk.finki.ukim.wpproekt.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
