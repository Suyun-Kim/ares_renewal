package kr.co.ares.application;

import kr.co.ares.common.Response;
import kr.co.ares.common.StatusEnum;
import kr.co.ares.domain.Vote;
import kr.co.ares.domain.dto.VoteDTO;
import kr.co.ares.service.VoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;

@Log4j2
@EnableWebMvc
@RestController
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @GetMapping("/votes")
    public ResponseEntity getVoteList(Pageable pageable) {

        Page<Vote> votes = voteService.findAll(pageable);

        return new ResponseEntity(new Response<>(StatusEnum.OK, true, votes), HttpStatus.OK);
    }

    @PostMapping("/votes")
    public ResponseEntity addVoteMember(@RequestBody @Valid VoteDTO voteDTO, BindingResult bindingResult) {
        Vote vote = voteService.addVoteMember(voteDTO);
        return null;
    }
}
