package kr.co.ares.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_Member")
@Entity
public class Member {

    @Id
    @Column(name = "Idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MemberId")
    private String memberId;

    @Column(name = "MemberPwd")
    private String memberPwd;

    @Column(name = "MemberName")
    private String memberName;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Grade")
    private Integer grade;

    @Column(name = "Team")
    private String team;

    @Column(name = "CreateDate")
    private Timestamp createDate;

    @Transient
    private String authToken;

    @Transient
    private Set<GrantedAuthority> authorities;
}
