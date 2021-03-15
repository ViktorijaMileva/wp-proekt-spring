package mk.finki.ukim.wpproekt.service.serviceImpl;

import mk.finki.ukim.wpproekt.model.Breed;
import mk.finki.ukim.wpproekt.model.Customer;
import mk.finki.ukim.wpproekt.model.dataTransfer.BreedDto;
import mk.finki.ukim.wpproekt.model.Food;
import mk.finki.ukim.wpproekt.repository.BreedRepository;
import mk.finki.ukim.wpproekt.repository.CustomerRepository;
import mk.finki.ukim.wpproekt.repository.FoodRepository;
import mk.finki.ukim.wpproekt.service.BreedService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreedServiceImpl implements BreedService {

    private final BreedRepository breedRepository;
    private final CustomerRepository customerRepository;
    private final FoodRepository foodRepository;

    public BreedServiceImpl(BreedRepository breedRepository, CustomerRepository customerRepository, FoodRepository foodRepository) {
        this.breedRepository = breedRepository;
        this.customerRepository = customerRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public Breed create(String growth, String breedName) {
        Breed breed = new Breed(growth, breedName);
        return this.breedRepository.save(breed);
    }

    @Override
    public Optional<Breed> create(BreedDto breedDto) {
        Customer customer = this.customerRepository.findById(breedDto.getCustomer()).orElseThrow();
        Food food = this.foodRepository.findById(breedDto.getFood()).orElseThrow();
        Breed breed = new Breed(breedDto.getGrowth(), breedDto.getBreedName());
        this.breedRepository.save(breed);
        return Optional.of(breed);
    }

    @Override
    public Breed delete(Long id) {
        Breed breed = this.breedRepository.findById(id).orElseThrow();
        this.breedRepository.delete(breed);
        return breed;
    }

    @Override
    public List<Breed> listAll() {
        return this.breedRepository.findAll();
    }

    @Override
    public Breed findById(Long id) {
        return this.breedRepository.findById(id).orElseThrow();
    }
}
