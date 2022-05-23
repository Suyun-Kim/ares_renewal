package kr.co.ares.infrastructure;

import kr.co.ares.domain.MatchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchResultRepository extends JpaRepository<MatchResult, Integer> {

    List<MatchResult> findTop3ByOrderByIdxDesc ();
}
