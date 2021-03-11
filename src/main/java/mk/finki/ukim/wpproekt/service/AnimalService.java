package mk.finki.ukim.wpproekt.service;

import mk.finki.ukim.wpproekt.model.Animal;
import mk.finki.ukim.wpproekt.model.Breed;
import mk.finki.ukim.wpproekt.model.Gender;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AnimalService {
    Animal create(String name, int age, Breed breed, Gender gender, String description, MultipartFile image);

    Animal edit(Long id, String name, int age, List<Long> breedList, Gender gender, String description, MultipartFile image);

    Animal delete(Long id);

    List<Animal> listAll();

    Animal findById(Long id);
}

