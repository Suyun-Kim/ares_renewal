package kr.co.ares.application;

import io.jsonwebtoken.Jwts;
import kr.co.ares.common.Response;
import kr.co.ares.common.StatusEnum;
import kr.co.ares.common.TokenProvider;
import kr.co.ares.domain.Member;
import kr.co.ares.domain.dto.MemberDTO;
import kr.co.ares.exception.BadRequestException;
import kr.co.ares.exception.BaseException;
import kr.co.ares.exception.ResourceNotFoundException;
import kr.co.ares.service.MemberService;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원정보 조회(일반 사용자용)
    @GetMapping("/members")
    public ResponseEntity<?> selectMemberInfo (MemberDTO memberDTO) {

        Member member = memberService.getMember(memberDTO.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재 하지 않는 회원입니다."));;

        return new ResponseEntity<>(new Response<>(StatusEnum.OK, true, member), HttpStatus.OK);
    }

}
