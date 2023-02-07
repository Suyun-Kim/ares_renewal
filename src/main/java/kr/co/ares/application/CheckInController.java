package kr.co.ares.application;

import kr.co.ares.common.Response;
import kr.co.ares.common.StatusEnum;
import kr.co.ares.domain.dto.CheckInDTO;
import kr.co.ares.service.CheckInService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class CheckInController {

    private final CheckInService checkInService;

    @PostMapping(value = "/checkIn", produces = "application/json")
    public ResponseEntity<?> checkInMatch (@RequestBody CheckInDTO req) {

        int result = checkInService.insertCheckIn(req);


        return new ResponseEntity<>(new Response<>(StatusEnum.OK, true), HttpStatus.OK);
    }

}
