package kr.co.ares.infrastructure;

import kr.co.ares.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    Schedule findFirstByOrderByPlayIndexDesc();

}
