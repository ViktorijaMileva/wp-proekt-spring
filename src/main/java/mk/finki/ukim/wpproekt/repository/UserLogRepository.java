package mk.finki.ukim.wpproekt.repository;

import mk.finki.ukim.wpproekt.model.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLogRepository extends JpaRepository<UserLog, Long> {
}
