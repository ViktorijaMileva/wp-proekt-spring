package mk.finki.ukim.wpproekt.service;

import mk.finki.ukim.wpproekt.model.Merchandise;

import java.util.List;

public interface MerchandiseService {

    Merchandise addProduct(double price, String description);

    Merchandise deleteProduct(Long id);

    Merchandise editProduct(Long id, double price, String description);

    List<Merchandise> listAllMerchandise();

    Merchandise findById(Long id);
}
