package kr.co.ares.infrastructure;

import kr.co.ares.domain.NotVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotVoteRepository extends JpaRepository<NotVote, Integer> {

    List<NotVote> findByGameIdx(Integer gameIdx);
    Optional<NotVote> findByGameIdxAndMemberIdx(Integer gameIdx, Integer MemberIdx);
}
