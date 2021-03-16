package mk.finki.ukim.wpproekt.service;

import mk.finki.ukim.wpproekt.model.Animal;
import mk.finki.ukim.wpproekt.model.Breed;
import mk.finki.ukim.wpproekt.model.dataTransfer.AnimalDto;
import mk.finki.ukim.wpproekt.model.Gender;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface AnimalService {
    Optional<Animal> create(String name, int age, Breed breed, Gender gender, String description, MultipartFile image);

    Optional<Animal> create(AnimalDto animalDto);

    Animal edit(Long id, String name, int age, List<Long> breedList, Gender gender, String description, MultipartFile image);

    Optional<Animal> edit(Long id, AnimalDto animalDto);

    Animal delete(Long id);

    List<Animal> listAll();

    Animal findById(Long id);


}

