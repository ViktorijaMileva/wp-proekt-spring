package mk.finki.ukim.wpproekt.web;

import mk.finki.ukim.wpproekt.model.Breed;
import mk.finki.ukim.wpproekt.service.BreedService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BreedController {

    private final BreedService breedService;

    public BreedController(BreedService breedService) {
        this.breedService = breedService;
    }

    @GetMapping("/breed")
    public List<Breed> showBreed(){
        return this.breedService.listAll();
    }

    @PostMapping("/breed")
    public Breed addBreed(@RequestBody String growth,
                          @RequestBody String breedName){
        return this.breedService.create(growth, breedName);
    }

    @PostMapping("/breed/{id}/delete")
    public void deleteBreed(@PathVariable Long id){
        this.breedService.delete(id);
    }
}
