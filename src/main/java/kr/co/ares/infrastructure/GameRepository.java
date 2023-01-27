package kr.co.ares.infrastructure;

import kr.co.ares.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Integer> {

    Game findFirstByOrderByIdxDesc();
    Game findFirstByIsEndOrderByIdxDesc(boolean isEnd);
    Optional<Game> findGameByIdx(Integer gameIdx);
}
