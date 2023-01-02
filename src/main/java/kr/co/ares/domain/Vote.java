package kr.co.ares.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_Vote")
@Entity
public class Vote {

    @Id
    @Column(name = "Idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "GameIdx")
    private Integer gameIdx;

    @Column(name = "MemberIdx")
    private Integer memberIdx;

    @Column(name = "IsVote")
    private boolean isVote;

    @Column(name = "CreateDate")
    private Timestamp createDate;

    @OneToOne
    @JoinColumn(name = "memberIdx", insertable = false, updatable = false)
    private Member member;

}
