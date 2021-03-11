package mk.finki.ukim.wpproekt.service;

import mk.finki.ukim.wpproekt.model.Employee;
import mk.finki.ukim.wpproekt.model.Role;

import java.util.List;

public interface EmployeeService {

    Employee register(String username, String password, String repeatPassword, String name, String surname, Role role);

    List<Employee> listAllEmployee();

    Employee findById(Long id);
}
