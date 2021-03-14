package mk.finki.ukim.wpproekt.repository;

import mk.finki.ukim.wpproekt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByUsername(String username);

    Optional<Employee> findByUsernameAndPassword(String username, String password);
}
