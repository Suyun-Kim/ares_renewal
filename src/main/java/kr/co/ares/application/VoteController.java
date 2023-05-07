package kr.co.ares.application;

import kr.co.ares.common.Response;
import kr.co.ares.common.StatusEnum;
import kr.co.ares.domain.Vote;
import kr.co.ares.domain.dto.VoteDTO;
import kr.co.ares.exception.BadRequestException;
import kr.co.ares.service.VoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping("/votes:schedule")
    public ResponseEntity<?> addVoteCurrentSchedule (@RequestBody @Valid VoteDTO voteDTO) {

        Integer result = voteService.addCurrentGameVote(voteDTO);

        return new ResponseEntity(new Response<>(StatusEnum.OK, true, result), HttpStatus.CREATED);

    }

    @GetMapping(value = "/votes/list")
    public ResponseEntity<?> getCurrentScheduleVoteList () {

        Map<String, Object> result = voteService.getCurrentScheduleVoteList();

        return new ResponseEntity(new Response<>(StatusEnum.OK, true, result), HttpStatus.OK);
    }

    @GetMapping(value = "/votes/count")
    public ResponseEntity<?> getCurrentVoteCount() {

        Map<String, Object> result = voteService.getCurrentScheduleVoteCount();
        return new ResponseEntity(new Response<>(StatusEnum.OK, true, result), HttpStatus.OK);
    }



}
