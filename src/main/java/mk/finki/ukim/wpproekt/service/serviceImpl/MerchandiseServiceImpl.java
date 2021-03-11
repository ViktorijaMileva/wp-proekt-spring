package mk.finki.ukim.wpproekt.service.serviceImpl;

import mk.finki.ukim.wpproekt.model.Merchandise;
import mk.finki.ukim.wpproekt.repository.MerchandiseRepository;
import mk.finki.ukim.wpproekt.service.MerchandiseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchandiseServiceImpl implements MerchandiseService {

    private final MerchandiseRepository merchandiseRepository;

    public MerchandiseServiceImpl(MerchandiseRepository merchandiseRepository) {
        this.merchandiseRepository = merchandiseRepository;
    }

    @Override
    public List<Merchandise> listAllMerchandise() {
        return this.merchandiseRepository.findAll();
    }

    @Override
    public Merchandise findById(Long id) {
        return this.merchandiseRepository.findById(id).orElseThrow();
    }

    @Override
    public Merchandise addProduct(double price, String description) {
        Merchandise merchandise = new Merchandise(price, description);
        return this.merchandiseRepository.save(merchandise);
    }

    @Override
    public Merchandise deleteProduct(Long id) {
        Merchandise merchandise = this.merchandiseRepository.findById(id).orElseThrow();
        this.merchandiseRepository.delete(merchandise);
        return  merchandise;
    }

    @Override
    public Merchandise editProduct(Long id, double price, String description) {
        Merchandise merchandise = this.merchandiseRepository.findById(id).orElseThrow();
        merchandise.setPrice(price);
        merchandise.setDescription(description);
        return this.merchandiseRepository.save(merchandise);
    }
}
