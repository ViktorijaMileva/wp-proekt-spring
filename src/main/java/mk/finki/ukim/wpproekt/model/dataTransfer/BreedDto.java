package mk.finki.ukim.wpproekt.model.dataTransfer;

import lombok.Data;

@Data
public class BreedDto {
    private String growth;
    private String breedName;
    private Long customer;
    private Long food;

    public BreedDto(String growth, String breedName, Long customer, Long food) {
        this.growth = growth;
        this.breedName = breedName;
        this.customer = customer;
        this.food = food;
    }

    public String getGrowth() {
        return growth;
    }

    public void setGrowth(String growth) {
        this.growth = growth;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public Long getFood() {
        return food;
    }

    public void setFood(Long food) {
        this.food = food;
    }
}
