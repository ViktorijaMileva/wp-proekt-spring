package mk.finki.ukim.wpproekt.service;

import mk.finki.ukim.wpproekt.model.dataTransfer.FoodDto;
import mk.finki.ukim.wpproekt.model.Food;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface FoodService {

    Food insertFood(String foodType, String intendedFor, int quantity, String description, MultipartFile image);

    Food delete(Long id);

    Food edit(Long id, String foodType, String intendedFor, int quantity, String description, MultipartFile image);

    List<Food> listAllFood();

    Food findById(Long id);

    Optional<Food> save(FoodDto foodDto);

    Optional<Food> edit(Long id, FoodDto foodDto);


}
