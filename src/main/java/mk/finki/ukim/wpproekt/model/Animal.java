package mk.finki.ukim.wpproekt.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Data
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalId;
    private String name;
    private int age;
    @ManyToOne
    private Breed breed;
    private String description;
    @Transient
    private MultipartFile image;
    @Enumerated
    private Gender gender;

    public Animal() {
    }

    public Animal(String name, int age, Breed breed, Gender gender, String description, MultipartFile image) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.breed = breed;
        this.description = description;
        this.image = image;
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

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
