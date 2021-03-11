package mk.finki.ukim.wpproekt.repository;

import mk.finki.ukim.wpproekt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
