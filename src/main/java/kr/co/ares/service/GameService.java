package kr.co.ares.service;

import kr.co.ares.domain.Game;
import kr.co.ares.infrastructure.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public Game getGameLast () {
        return gameRepository.findFirstByOrderByIdxDesc();
    }
}
