package kr.co.ares.service;

import kr.co.ares.domain.Game;
import kr.co.ares.domain.dto.CheckInDTO;
import kr.co.ares.domain.dto.GameDTO;
import kr.co.ares.infrastructure.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public Game getGameLast () {
        return gameRepository.findFirstByOrderByIdxDesc();
    }

    public Optional<Game> getGameByIdx (Integer gameIdx) {
        return gameRepository.findGameByIdx(gameIdx);
    }


    public Game getVotedGameInfo (boolean isEnd) {
        return gameRepository.findFirstByIsEndOrderByIdxDesc(isEnd);
    }

    public Double getGameDistance (Integer gameIdx, CheckInDTO checkInDTO) {
        return gameRepository.findGameByDistance(gameIdx, checkInDTO.getLan(), checkInDTO.getLon());

    }

}
