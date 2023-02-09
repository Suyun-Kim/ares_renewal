package kr.co.ares.infrastructure;

import kr.co.ares.domain.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Integer> {

    CheckIn findByGameIdxAndMemberIdx(Integer gameIdx, Integer MemberIdx);

}
