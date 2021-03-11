package mk.finki.ukim.wpproekt.web;

import mk.finki.ukim.wpproekt.model.Breed;
import mk.finki.ukim.wpproekt.model.Food;
import mk.finki.ukim.wpproekt.service.FoodService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/food")
    public List<Food> showAllFood(){
        return this.foodService.listAllFood();
    }

    @PostMapping("/food")
    public Food addFood(@RequestBody String foodType,
                        @RequestBody String intendedFor,
                        @RequestBody int quantity,
                        @RequestBody String description,
                        @RequestBody MultipartFile image){
        return this.foodService.insertFood(foodType, intendedFor, quantity, description, image);
    }

    @PostMapping("/food/{id}")
    public Food editFood(@PathVariable Long id,
                         @RequestBody String foodType,
                         @RequestBody String intendedFor,
                         @RequestBody int quantity,
                         @RequestBody String description,
                         @RequestBody MultipartFile image){
        return this.foodService.edit(id, foodType, intendedFor, quantity, description, image);
    }

    @PostMapping("/food/{id}/delete")
    public void deleteFood(@PathVariable Long id){
        this.foodService.delete(id);
    }
}
