package kr.co.ares.infrastructure;

import kr.co.ares.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {

    Game findFirstByOrderByIdxDesc();
}
