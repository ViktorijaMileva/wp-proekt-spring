package mk.finki.ukim.wpproekt.service;

import mk.finki.ukim.wpproekt.model.Sale;

import java.util.Date;
import java.util.List;

public interface SaleService {

    Sale insertSale(Date saleDate);

    List<Sale> listAllSale();

    Sale findById(Long id);
}
