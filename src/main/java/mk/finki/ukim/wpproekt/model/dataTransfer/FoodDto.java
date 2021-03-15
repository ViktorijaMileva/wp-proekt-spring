package mk.finki.ukim.wpproekt.model.dataTransfer;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FoodDto {
    private String foodType;
    private String intendedFor;
    private int quantity;
    private String description;
    private MultipartFile image;


    public FoodDto(String foodType, String intendedFor, int quantity, String description, MultipartFile image) {
        this.foodType = foodType;
        this.intendedFor = intendedFor;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getIntendedFor() {
        return intendedFor;
    }

    public void setIntendedFor(String intendedFor) {
        this.intendedFor = intendedFor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
