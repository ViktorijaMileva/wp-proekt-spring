package mk.finki.ukim.wpproekt.service;

import mk.finki.ukim.wpproekt.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> listAllCustomers();

    Customer findById(Long id);

    Customer create(String name, String surname, String phoneNumber, String email);

    Customer delete(Long id);

    Customer edit(Long id, String name, String surname, String phoneNumber, String email);
}
