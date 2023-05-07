package kr.co.ares.application;

import kr.co.ares.common.Response;
import kr.co.ares.common.StatusEnum;
import kr.co.ares.domain.*;
import kr.co.ares.domain.dto.CheckInDTO;
import kr.co.ares.domain.dto.GameDTO;
import kr.co.ares.exception.ResourceNotFoundException;
import kr.co.ares.service.GameService;
import kr.co.ares.service.MemberService;
import kr.co.ares.service.VoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping(value = "/games:distance/{gameIdx}", produces = "application/json")
    public ResponseEntity<?> selectLastGameDistance(@PathVariable Integer gameIdx, CheckInDTO req) {
        Double result = gameService.getGameDistance(gameIdx, req);
        return new ResponseEntity<>(new Response<>(StatusEnum.OK, true, result), HttpStatus.OK);
    }

    @GetMapping(value = "/games/current", produces = "application/json")
    public ResponseEntity<?> selectCurrentGame() {

        Schedule result = gameService.getCurrentSchedule();
        return new ResponseEntity<>(new Response<>(StatusEnum.OK, true, result), HttpStatus.OK);

    }

    @GetMapping(value = "/games", produces = "application/json")
    public ResponseEntity<?> selectGames() {

        List<Schedule> result = gameService.getScheduleList();
        return new ResponseEntity<>(new Response<>(StatusEnum.OK, true, result), HttpStatus.OK);
    }


}
