package mk.finki.ukim.wpproekt.service.serviceImpl;

import mk.finki.ukim.wpproekt.model.Sale;
import mk.finki.ukim.wpproekt.repository.SaleRepository;
import mk.finki.ukim.wpproekt.service.SaleService;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> listAllSale() {
        return this.saleRepository.findAll();
    }

    @Override
    public Sale findById(Long id) {
        return this.saleRepository.findById(id).orElseThrow();
    }

    @Override
    public Sale insertSale(Date saleDate) {
        Date date = java.util.Calendar.getInstance().getTime();
        Sale sale = new Sale(date);
        return this.saleRepository.save(sale);
    }


}
