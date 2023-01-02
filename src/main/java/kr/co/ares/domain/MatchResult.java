package kr.co.ares.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_MatchResult")
@Entity
public class MatchResult {

    @Id
    @Column(name = "Idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column(name = "GameIdx")
    private Integer gameIdx;

    @Column(name = "Win")
    private String win;

    @Column(name = "lose")
    private String lose;

    @Column(name = "WinScore")
    private Integer winScore;

    @Column(name = "LoseScore")
    private Integer loseScore;

    @Column(name = "CreateDate")
    private Timestamp createDate;

    @OneToOne
    @JoinColumn(name = "gameIdx")
    private Game game;
}
