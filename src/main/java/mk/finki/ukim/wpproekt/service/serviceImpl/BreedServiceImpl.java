package mk.finki.ukim.wpproekt.service.serviceImpl;

import mk.finki.ukim.wpproekt.model.Breed;
import mk.finki.ukim.wpproekt.repository.BreedRepository;
import mk.finki.ukim.wpproekt.service.BreedService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedServiceImpl implements BreedService {

    private final BreedRepository breedRepository;

    public BreedServiceImpl(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    @Override
    public Breed create(String growth, String breedName) {
        Breed breed = new Breed(growth, breedName);
        return this.breedRepository.save(breed);
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
