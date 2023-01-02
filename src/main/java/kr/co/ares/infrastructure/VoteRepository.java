package kr.co.ares.infrastructure;

import kr.co.ares.domain.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Override
    Page<Vote> findAll(Pageable pageable);
    List<Vote> findByGameIdx (Integer gameId);
    List<Vote> findByGameIdxAndIsVote(Integer gameId, boolean isVote);
    Optional<Vote> findByGameIdxAndMemberIdx(Integer gameId, Integer memberIdx);

}
