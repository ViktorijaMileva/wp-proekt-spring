package mk.finki.ukim.wpproekt.web;

import mk.finki.ukim.wpproekt.model.Animal;
import mk.finki.ukim.wpproekt.model.dataTransfer.AnimalDto;
import mk.finki.ukim.wpproekt.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/animals/add")
    public ResponseEntity<Animal> addAnimal(@RequestBody AnimalDto animalDto){
        return this.animalService.create(animalDto)
                .map(animal -> ResponseEntity.ok().body(animal))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/animals/{id}/delete")
    public void deleteAnimal(@PathVariable Long id){
        this.animalService.delete(id);
    }


    @PostMapping("/animals/{id}")
    public ResponseEntity<Animal> editAnimal(@PathVariable Long id,
                             @RequestBody AnimalDto animalDto){
        return this.animalService.edit(id, animalDto)
                .map(animal -> ResponseEntity.ok().body(animal))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
