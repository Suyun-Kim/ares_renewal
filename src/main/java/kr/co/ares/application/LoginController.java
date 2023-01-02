package kr.co.ares.application;

import kr.co.ares.common.Response;
import kr.co.ares.common.StatusEnum;
import kr.co.ares.common.TokenProvider;
import kr.co.ares.domain.Member;
import kr.co.ares.domain.dto.MemberDTO;
import kr.co.ares.exception.BadRequestException;
import kr.co.ares.exception.ResourceNotFoundException;
import kr.co.ares.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;
    private final TokenProvider tokenProvider;


    @PostMapping(value = "/auth", produces = "application/json")
    public ResponseEntity<?> login(@RequestBody MemberDTO memberDTO) {

        Optional<Member> member = memberService.getMember(memberDTO.getMemberId());

        if(!member.isPresent()) {
            throw new ResourceNotFoundException("존재 하지 않는 회원입니다.");
        }

        if (!memberDTO.getMemberPwd().equals(member.get().getMemberPwd())) {
            throw new BadRequestException("잘못된 비밀번호입니다.");
        }

        UserDetails userDetails = memberService.loadUserByUsername(memberDTO.getMemberId());

        Member authMember = Member.builder()
                .id(member.get().getId())
                .grade(member.get().getGrade())
                .memberName(userDetails.getUsername())
                .authToken(tokenProvider.createToken(member.get().getMemberId()))
                .build();

        return new ResponseEntity<>(new Response<>(StatusEnum.OK, true, authMember), HttpStatus.OK);
    }
}
