package mk.finki.ukim.wpproekt.service.serviceImpl;

import mk.finki.ukim.wpproekt.model.dataTransfer.FoodDto;
import mk.finki.ukim.wpproekt.model.Food;
import mk.finki.ukim.wpproekt.repository.BreedRepository;
import mk.finki.ukim.wpproekt.repository.FoodRepository;
import mk.finki.ukim.wpproekt.service.FoodService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final BreedRepository breedRepository;


    public FoodServiceImpl(FoodRepository foodRepository, BreedRepository breedRepository) {
        this.foodRepository = foodRepository;
        this.breedRepository = breedRepository;
    }

    @Override
    public List<Food> listAllFood() {
        return this.foodRepository.findAll();
    }

    @Override
    public Food findById(Long id) {
        return this.foodRepository.findById(id).orElseThrow();
    }

    @Override
    public Food insertFood(String foodType, String intendedFor, int quantity, String description, MultipartFile image) {
        Food food = new Food(foodType, intendedFor, quantity, description, image);
        return this.foodRepository.save(food);
    }

    @Override
    public Optional<Food> save(FoodDto foodDto) {
        Food food = new Food(foodDto.getFoodType(), foodDto.getIntendedFor(), foodDto.getQuantity(), foodDto.getDescription(), foodDto.getImage());
        this.foodRepository.save(food);
        return Optional.of(food);
    }

    @Override
    public Optional<Food> edit(Long id, FoodDto foodDto) {
        Food food = this.foodRepository.findById(id).orElseThrow();
        food.setFoodType(foodDto.getFoodType());
        food.setIntendedFor(foodDto.getIntendedFor());
        food.setQuantity(foodDto.getQuantity());
        food.setDescription(foodDto.getDescription());
        food.setImage(foodDto.getImage());
        return Optional.of(food);
    }

    @Override
    public Food delete(Long id) {
        Food food = this.foodRepository.findById(id).orElseThrow();
        this.foodRepository.delete(food);
        return food;
    }

    @Override
    public Food edit(Long id, String foodType, String intendedFor, int quantity, String description, MultipartFile image) {
        Food food = this.foodRepository.findById(id).orElseThrow();
        food.setFoodType(foodType);
        food.setIntendedFor(intendedFor);
        food.setQuantity(quantity);
        food.setDescription(description);
        food.setImage(image);
        return this.foodRepository.save(food);
    }

}
