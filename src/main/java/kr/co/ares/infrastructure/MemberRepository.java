package kr.co.ares.infrastructure;

import kr.co.ares.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByMemberId(String memberId);
    List<Member> findAllByGradeNot(Integer grade);
}
