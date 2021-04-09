package mk.finki.ukim.wpproekt.repository.views;

import mk.finki.ukim.wpproekt.model.views.AnimalsPerBreedView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsPerBreedViewRepository extends JpaRepository<AnimalsPerBreedView, Long> {
}
