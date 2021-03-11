package mk.finki.ukim.wpproekt.service.serviceImpl;

import mk.finki.ukim.wpproekt.model.Employee;
import mk.finki.ukim.wpproekt.model.Role;
import mk.finki.ukim.wpproekt.repository.EmployeeRepository;
import mk.finki.ukim.wpproekt.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee register(String username, String password, String repeatPassword, String name, String surname, Role role) {
        Employee employee = new Employee(name, surname, username, password, role);
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return this.employeeRepository.findById(id).orElseThrow();
    }
}
