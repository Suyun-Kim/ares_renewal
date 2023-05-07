package kr.co.ares.infrastructure;

import kr.co.ares.domain.GameNotVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameNotVoteRepository extends JpaRepository<GameNotVote, Integer> {

    GameNotVote findByPlayIdxAndMemberId(Integer playIdx, String memberId);
    List<GameNotVote> findByPlayIdx(Integer playIdx);

}
