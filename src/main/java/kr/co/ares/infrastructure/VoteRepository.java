package kr.co.ares.infrastructure;

import kr.co.ares.domain.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Override
    Page<Vote> findAll(Pageable pageable);

}
