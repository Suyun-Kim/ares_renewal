package kr.co.ares.application;

import kr.co.ares.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping(value = "/game", produces = "application/json")
    public ResponseEntity selectGameInfo () {
        return null;
    }

}
