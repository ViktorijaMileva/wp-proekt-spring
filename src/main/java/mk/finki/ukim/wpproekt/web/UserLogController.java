package mk.finki.ukim.wpproekt.web;

import mk.finki.ukim.wpproekt.model.UserLog;
import mk.finki.ukim.wpproekt.service.UserLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class UserLogController {

    private final UserLogService userLogService;

    public UserLogController(UserLogService userLogService) {
        this.userLogService = userLogService;
    }

    @GetMapping("/userLog")
    public List<UserLog> showAllUserLog(){
        return this.userLogService.listAllUserLogs();
    }

    @PostMapping("/userLog")
    public UserLog addUserLog(@RequestBody Date loginDate){
        return this.userLogService.insertUserLoginDate(loginDate);
    }
}
