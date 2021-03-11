package mk.finki.ukim.wpproekt.web;

import mk.finki.ukim.wpproekt.model.Customer;
import mk.finki.ukim.wpproekt.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public List<Customer> showCustomers(){
        return this.customerService.listAllCustomers();
    }

    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody String name,
                                @RequestBody String surname,
                                @RequestBody String phoneNumber,
                                @RequestBody String email){
        return this.customerService.create(name, surname, phoneNumber, email);
    }


    @PostMapping("/customer/{id}")
    public Customer editCustomer(@PathVariable Long id,
                                 @RequestBody String name,
                                 @RequestBody String surname,
                                 @RequestBody String phoneNumber,
                                 @RequestBody String email){
        return this.customerService.edit(id, name, surname, phoneNumber, email);
    }

    @PostMapping("/customer/{id}/delete")
    public void deleteCustomer(@PathVariable Long id){
        this.customerService.delete(id);
    }

}
