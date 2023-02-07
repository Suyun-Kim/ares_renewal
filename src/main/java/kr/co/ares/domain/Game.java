package kr.co.ares.domain;

import lombok.*;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_Game")
@Entity
public class Game {

    @Id
    @Column(name = "Idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column(name = "Title")
    private String title;

    @Column(name = "Location")
    private String location;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "StartTime")
    private Time startTime;

    @Column(name = "TardinessTime")
    private Time tardinessTime;

    @Column(name = "Team1")
    private String team1;

    @Column(name = "Team2")
    private String team2;

    @Column(name = "OtherTeam")
    private String otherTeam;

    @Column(name = "CreateDate")
    private Timestamp createDate;

    @Column(name = "IsEnd")
    private Boolean isEnd;

    @Transient
    private Integer voteCount = 0;

    @Transient
    private Integer notVoteCount = 0;

    @Transient
    private Integer noVoteCount = 0;

    @Transient
    private List<Member> voteMembers;

    @Transient
    private List<Member> notVoteMembers;

    @Transient
    private List<Member> noVoteMembers;



}
