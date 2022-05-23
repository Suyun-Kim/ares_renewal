package kr.co.ares.service;

import kr.co.ares.domain.CustomUserDetails;
import kr.co.ares.domain.Member;
import kr.co.ares.domain.dto.MemberDTO;
import kr.co.ares.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public Optional<Member> getMember (String memberId) {
        return memberRepository.findByMemberId(memberId);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByMemberId(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        if (member != null) {
            switch (member.getGrade()) {
                case 1 :
                    authorities.add(new SimpleGrantedAuthority("USER"));
                case 2 :
                    authorities.add(new SimpleGrantedAuthority("MANAGER"));
                case 3 :
                    authorities.add(new SimpleGrantedAuthority("MANAGER"));
                default:
                    authorities.add(new SimpleGrantedAuthority("ADMIN"));
            }

        }

        CustomUserDetails customUserDetails = new CustomUserDetails(member.getMemberId(), member.getMemberPwd(), authorities);
        return customUserDetails;
    }
}
