package kr.co.ares.infrastructure;

import kr.co.ares.domain.GameVote;
import kr.co.ares.domain.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameVoteRepository extends JpaRepository<GameVote, Integer> {

    GameVote findByPlayIdxAndMemberId(Integer playIdx, String memberId);
    List<GameVote> findByPlayIdx(Integer playIdx);

}
