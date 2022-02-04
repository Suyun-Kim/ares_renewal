package kr.co.ares.service;

import kr.co.ares.domain.Member;
import kr.co.ares.domain.dto.MemberDTO;
import kr.co.ares.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Optional<Member> getMember (String memberId) {
        return memberRepository.findByMemberId(memberId);
    }


}
