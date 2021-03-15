package mk.finki.ukim.wpproekt.web;

import mk.finki.ukim.wpproekt.model.dataTransfer.FoodDto;
import mk.finki.ukim.wpproekt.model.Food;
import mk.finki.ukim.wpproekt.service.FoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/food/add")
    public ResponseEntity<Food> addFood(@RequestBody FoodDto foodDto){
        return this.foodService.save(foodDto)
                .map(food -> ResponseEntity.ok().body(food))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PostMapping("food/edit/{id}")
    public ResponseEntity<Food> save(@PathVariable Long id, @RequestBody FoodDto foodDto) {
        return this.foodService.edit(id, foodDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @PostMapping("/food/{id}/delete")
    public void deleteFood(@PathVariable Long id){
        this.foodService.delete(id);
    }
}
