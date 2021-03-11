package mk.finki.ukim.wpproekt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.nio.channels.MulticastChannel;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties(value = { "foodList" })
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long breedId;
    private String growth;
    private String breedName;
    @ManyToMany
    private List<Customer> customers;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Food> foodList;
    public Breed() {
    }

    public Breed(String growth, String breedName) {
        this.growth = growth;
        this.breedName = breedName;
    }
}
