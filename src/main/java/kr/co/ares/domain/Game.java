package kr.co.ares.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
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

    @Transient
    private Integer voteCount = 0;

    @Transient
    private Integer notVoteCount = 0;



}
