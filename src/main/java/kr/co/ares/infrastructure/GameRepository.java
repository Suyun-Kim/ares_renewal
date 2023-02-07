package kr.co.ares.infrastructure;

import kr.co.ares.domain.Game;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Integer> {

    Game findFirstByOrderByIdxDesc();
    Game findFirstByIsEndOrderByIdxDesc(boolean isEnd);
    Optional<Game> findGameByIdx(Integer gameIdx);

    @Query(value = "SELECT ST_DISTANCE_SPHERE(POINT(?2, ?3), Coordinates) AS distance FROM TB_Game WHERE Idx = ?1 ",
            nativeQuery = true)
    Double findGameByDistance(Integer gameIdx, Double lat, Double lon);
}
