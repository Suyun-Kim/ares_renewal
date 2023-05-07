package kr.co.ares.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ares_schedule")
@Entity
public class Schedule {

    @Id
    @Column(name = "PLAY_INDEX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer playIndex;

    @Column(name = "PLAY_TIME")
    public Timestamp playTime;

    @Column(name = "PLAY_LOCATION")
    public String playLocation;

    @Column(name = "PLAY_TYPE")
    public String playType;

    @Column(name = "PLAY_TIME_LIMIT")
    public Timestamp playTimeLimit;

    @Column(name = "PLAY_WINNER")
    public String playWinner;

    @Column(name = "PLAY_TEAM1")
    public String playTeam1;

    @Column(name = "PLAY_TEAM2")
    public String playTeam2;

}
