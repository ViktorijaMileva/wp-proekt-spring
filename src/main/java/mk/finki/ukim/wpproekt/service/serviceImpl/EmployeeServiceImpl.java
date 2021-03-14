package mk.finki.ukim.wpproekt.service.serviceImpl;

import mk.finki.ukim.wpproekt.model.Employee;
import mk.finki.ukim.wpproekt.model.Role;
import mk.finki.ukim.wpproekt.model.exception.InvalidUsernameOrPasswordException;
import mk.finki.ukim.wpproekt.model.exception.PasswordsDoNotMatchException;
import mk.finki.ukim.wpproekt.model.exception.UsernameAlreadyExistsException;
import mk.finki.ukim.wpproekt.repository.EmployeeRepository;
import mk.finki.ukim.wpproekt.service.EmployeeService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee register(String username, String password, String repeatPassword, String name, String surname, Role role) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()){
            throw new InvalidUsernameOrPasswordException();
        }
        if (!password.equals(repeatPassword)){
            throw new PasswordsDoNotMatchException();
        }
        if (this.employeeRepository.findByUsername(username).isPresent()){
            throw new UsernameAlreadyExistsException(username);
        }
        Employee employee = new Employee(name, surname, username, password, role);
        return this.employeeRepository.save(employee);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.employeeRepository.findByUsername(username).orElseThrow();
    }
}
