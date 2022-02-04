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
    private Long id;

    @Column(name = "GameIdx")
    private Long gameIdx;

    @Column(name = "MemberIdx")
    private Long memberIdx;

    @Column(name = "IsVote")
    private boolean isVote;

    @Column(name = "CreateDate")
    private Timestamp createDate;

}
