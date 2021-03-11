package mk.finki.ukim.wpproekt.web;

import mk.finki.ukim.wpproekt.model.Sale;
import mk.finki.ukim.wpproekt.service.SaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/sale")
    public List<Sale> showAllSale(){
        return this.saleService.listAllSale();
    }

    @PostMapping("/sale")
    public Sale addSale(@RequestBody Date saleDate){
        return this.saleService.insertSale(saleDate);
    }
}
