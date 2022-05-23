package kr.co.ares.infrastructure;

import kr.co.ares.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    List<Notice> findTop3ByOrderByIdxDesc();
}
