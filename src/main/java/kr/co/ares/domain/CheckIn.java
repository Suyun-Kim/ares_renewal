package kr.co.ares.domain;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.time.OffsetDateTime;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CheckIn")
@Entity
public class CheckIn {

    @Id
    @Column(name = "Idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "GameIdx")
    private Integer gameIdx;

    @Column(name = "MemberIdx")
    private Integer memberIdx;

    @Column(name = "CheckInDate")
    private OffsetDateTime checkInDate;


}
