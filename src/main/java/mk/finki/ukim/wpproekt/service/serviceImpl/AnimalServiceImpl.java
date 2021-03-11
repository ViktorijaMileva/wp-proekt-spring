package mk.finki.ukim.wpproekt.service.serviceImpl;

import mk.finki.ukim.wpproekt.model.Animal;
import mk.finki.ukim.wpproekt.model.Breed;
import mk.finki.ukim.wpproekt.model.Gender;
import mk.finki.ukim.wpproekt.repository.AnimalRepository;
import mk.finki.ukim.wpproekt.repository.BreedRepository;
import mk.finki.ukim.wpproekt.service.AnimalService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;
    private final BreedRepository breedRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository, BreedRepository breedRepository) {
        this.animalRepository = animalRepository;
        this.breedRepository = breedRepository;
    }

    @Override
    public Animal create(String name, int age, Breed breed, Gender gender, String description, MultipartFile image) {
        Animal animal = new Animal(name, age, breed, gender, description, image);
        return this.animalRepository.save(animal);
    }

    @Override
    public Animal edit(Long id, String name, int age, List<Long> breedList, Gender gender, String description, MultipartFile image) {
        Animal animal = this.animalRepository.findById(id).orElseThrow();
        List<Breed> breeds = this.breedRepository.findAllById(breedList);
        animal.setName(name);
        animal.setAge(age);
        animal.setGender(gender);
        animal.setDescription(description);
        animal.setImage(image);
        return this.animalRepository.save(animal);
    }

    @Override
    public Animal delete(Long id) {
        Animal animal = this.animalRepository.findById(id).orElseThrow();
        this.animalRepository.delete(animal);
        return animal;
    }

    @Override
    public List<Animal> listAll() {
        return this.animalRepository.findAll();
    }

    @Override
    public Animal findById(Long id) {
        return this.animalRepository.findById(id).orElseThrow();
    }
}
