package mk.finki.ukim.wpproekt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EmployeeId;
    private String name;
    private String surname;
    private String username;
    private String Password;
    private String phone;
    private String address;
    private Date EmployeeFrom;
    private Date EmployeeTo;
    @OneToMany
    private List<Sale> sales;
    @Enumerated
    private Role role;

    public Employee(String name, String surname, String username, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        Password = password;
        this.role = role;
    }

    public Employee(){

    }
}
