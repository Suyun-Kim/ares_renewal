package kr.co.ares.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ares_game_vote")
@Entity
public class GameVote {

    @Id
    @Column(name = "vote_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer voteIdx;

    @Column(name = "play_idx")
    public Integer playIdx;

    @Column(name = "member_id")
    public String memberId;

    @Transient
    public String memberTeam;

    @Column(name = "attendance_time")
    public Timestamp attendance_time;



}
