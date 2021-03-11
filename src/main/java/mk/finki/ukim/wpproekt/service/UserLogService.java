package mk.finki.ukim.wpproekt.service;

import mk.finki.ukim.wpproekt.model.UserLog;

import java.util.Date;
import java.util.List;

public interface UserLogService {

    UserLog insertUserLoginDate(Date loginDate);

    List<UserLog> listAllUserLogs();

    UserLog findById(Long id);

}
