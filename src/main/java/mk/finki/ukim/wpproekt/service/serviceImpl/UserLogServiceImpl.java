package mk.finki.ukim.wpproekt.service.serviceImpl;

import mk.finki.ukim.wpproekt.model.Sale;
import mk.finki.ukim.wpproekt.model.UserLog;
import mk.finki.ukim.wpproekt.repository.UserLogRepository;
import mk.finki.ukim.wpproekt.service.UserLogService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserLogServiceImpl implements UserLogService {

    private final UserLogRepository userLogRepository;

    public UserLogServiceImpl(UserLogRepository userLogRepository) {
        this.userLogRepository = userLogRepository;
    }

    @Override
    public List<UserLog> listAllUserLogs() {
        return this.userLogRepository.findAll();
    }

    @Override
    public UserLog findById(Long id) {
        return this.userLogRepository.findById(id).orElseThrow();
    }

    @Override
    public UserLog insertUserLoginDate(Date loginDate) {
        Date date = java.util.Calendar.getInstance().getTime();
        UserLog userLog = new UserLog(date);
        return this.userLogRepository.save(userLog);

    }

}
