package kr.co.ares.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ares_game_vote_not")
@Entity
public class GameNotVote {

    @Id
    @Column(name = "not_vote_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer voteIdx;

    @Column(name = "play_idx")
    public Integer playIdx;

    @Column(name = "member_id")
    public String memberId;

    @Transient
    public String memberTeam;

    @Column(name = "create_date")
    public Timestamp createDate;

}
