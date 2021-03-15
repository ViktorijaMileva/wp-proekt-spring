package mk.finki.ukim.wpproekt.service;

import mk.finki.ukim.wpproekt.model.Breed;
import mk.finki.ukim.wpproekt.model.dataTransfer.BreedDto;

import java.util.List;
import java.util.Optional;

public interface BreedService {
    Breed create(String growth, String breedName);

    Optional<Breed> create(BreedDto breedDto);

    Breed delete(Long id);

    List<Breed> listAll();

    Breed findById(Long id);

}
