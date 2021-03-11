package mk.finki.ukim.wpproekt.web;

import mk.finki.ukim.wpproekt.model.Merchandise;
import mk.finki.ukim.wpproekt.service.MerchandiseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MerchandiseController {

    private final MerchandiseService merchandiseService;

    public MerchandiseController(MerchandiseService merchandiseService) {
        this.merchandiseService = merchandiseService;
    }

    @GetMapping("/merchandise")
    public List<Merchandise> showMerchandise(){
        return this.merchandiseService.listAllMerchandise();
    }

    @PostMapping("/merchandise")
    public Merchandise addMerchandise(@RequestBody double price,
                                      @RequestBody String description){
        return this.merchandiseService.addProduct(price, description);
    }

    @PostMapping("/merchandise/{id}")
    public Merchandise editMerchandise(@PathVariable Long id,
                                       @RequestBody double price,
                                       @RequestBody String description){
        return this.merchandiseService.editProduct(id, price, description);
    }

    @PostMapping("/merchandise{id}/delete")
    public void deleteMerchandise(@PathVariable Long id){
        this.merchandiseService.deleteProduct(id);
    }

}
