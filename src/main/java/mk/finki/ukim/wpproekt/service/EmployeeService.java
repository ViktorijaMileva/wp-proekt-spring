package mk.finki.ukim.wpproekt.service;

import mk.finki.ukim.wpproekt.model.Employee;
import mk.finki.ukim.wpproekt.model.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface EmployeeService extends UserDetailsService {

    Employee register(String username, String password, String repeatPassword, String name, String surname, Role role);

}
