package mk.finki.ukim.wpproekt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class UserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;
    private Date loginDate;
    private Date logoutDate;
    @ManyToOne
    private Employee employee;
    public UserLog(){

    }

    public UserLog(Date loginDate) {
        this.loginDate = loginDate;
    }
}
