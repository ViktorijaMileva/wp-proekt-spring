package mk.finki.ukim.wpproekt.model.dataTransfer;

import lombok.Data;
import mk.finki.ukim.wpproekt.model.Gender;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AnimalDto {

    private String name;
    private int age;
    private Long breed;
    private String description;
    private MultipartFile image;
    private Gender gender;

    public AnimalDto(String name, int age, Long breed, String description, MultipartFile image, Gender gender) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.description = description;
        this.image = image;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getBreed() {
        return breed;
    }

    public void setBreed(Long breed) {
        this.breed = breed;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
