package mk.finki.ukim.wpproekt.web;

import mk.finki.ukim.wpproekt.model.Animal;
import mk.finki.ukim.wpproekt.model.Breed;
import mk.finki.ukim.wpproekt.model.Gender;
import mk.finki.ukim.wpproekt.service.AnimalService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animals")
    public List<Animal> showAnimals(){
        List<Animal> animals = this.animalService.listAll();
        return animals;
    }

    @PostMapping("/animals")
    public Animal addAnimal(@RequestBody String name,
                            @RequestBody int age,
                            @RequestBody Breed breed,
                            @RequestBody Gender gender,
                            @RequestBody String description,
                            @RequestBody MultipartFile image){
        return this.animalService.create(name, age, breed, gender, description, image);
    }

    @PostMapping("/animals/{id}/delete")
    public void deleteAnimal(@PathVariable Long id){
        this.animalService.delete(id);
    }


    @PostMapping("/animals/{id}")
    public Animal editAnimal(@PathVariable Long id,
                             @RequestBody String name,
                             @RequestBody int age,
                             @RequestBody List<Long> breedList,
                             @RequestBody Gender gender,
                             @RequestBody String description,
                             @RequestBody MultipartFile image){
        return this.animalService.edit(id, name, age, breedList, gender, description, image);
    }
}
