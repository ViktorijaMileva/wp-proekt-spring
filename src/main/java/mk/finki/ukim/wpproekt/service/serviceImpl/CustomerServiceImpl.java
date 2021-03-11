package mk.finki.ukim.wpproekt.service.serviceImpl;

import mk.finki.ukim.wpproekt.model.Customer;
import mk.finki.ukim.wpproekt.repository.CustomerRepository;
import mk.finki.ukim.wpproekt.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(String name, String surname, String phoneNumber, String email) {
        Customer customer = new Customer(name, surname, phoneNumber, email);
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer delete(Long id) {
        Customer customer = this.customerRepository.findById(id).orElseThrow();
        this.customerRepository.delete(customer);
        return customer;
    }

    @Override
    public Customer edit(Long id, String name, String surname, String phoneNumber, String email) {
        Customer customer = this.customerRepository.findById(id).orElseThrow();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);
        return this.customerRepository.save(customer);
    }

    @Override
    public List<Customer> listAllCustomers() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return this.customerRepository.findById(id).orElseThrow();
    }
}
