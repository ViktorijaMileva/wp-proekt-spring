package mk.finki.ukim.wpproekt.model.dataTransfer;

import lombok.Data;
import mk.finki.ukim.wpproekt.model.Employee;
import mk.finki.ukim.wpproekt.model.Role;

@Data
public class UserDetailsDto {
    private String username;
    private Role role;

    public static UserDetailsDto of(Employee employee){
        UserDetailsDto details = new UserDetailsDto();
        details.username = employee.getUsername();
        details.role = employee.getRole();
        return details;
    }

}
