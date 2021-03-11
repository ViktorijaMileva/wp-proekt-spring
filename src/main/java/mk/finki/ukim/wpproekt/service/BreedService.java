package mk.finki.ukim.wpproekt.service;

import mk.finki.ukim.wpproekt.model.Breed;

import java.util.List;

public interface BreedService {
    Breed create(String growth, String breedName);

    Breed delete(Long id);

    List<Breed> listAll();

    Breed findById(Long id);

}
