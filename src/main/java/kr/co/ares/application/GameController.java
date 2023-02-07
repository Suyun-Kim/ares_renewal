package kr.co.ares.application;

import kr.co.ares.common.Response;
import kr.co.ares.common.StatusEnum;
import kr.co.ares.domain.Game;
import kr.co.ares.domain.Member;
import kr.co.ares.domain.NotVote;
import kr.co.ares.domain.Vote;
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
    private final VoteService voteService;
    private final MemberService memberService;

    @GetMapping(value = "/games:voting", produces = "application/json")
    public ResponseEntity<?> selectVotedGameInfo() {

        Game result = gameService.getGameLast();

        return new ResponseEntity<>(new Response<>(StatusEnum.OK, true, result), HttpStatus.OK);
    }

    @GetMapping(value = "/games/{gameIdx}", produces = "application/json")
    public ResponseEntity<?> selectGameInfo(@PathVariable Integer gameIdx) {
        Map<String, Object> result = new HashMap<>();

        List<Member> memberList = memberService.getAllVoteMember();
        Optional<Game> gameInfo = gameService.getGameByIdx(gameIdx);
        List<Member> team1VoteList = new ArrayList<>();
        List<Member> team2VoteList = new ArrayList<>();
        List<Member> team1NotVoteList = new ArrayList<>();
        List<Member> team2NotVoteList = new ArrayList<>();
        List<Member> team1NoVoteList = new ArrayList<>();
        List<Member> team2NoVoteList = new ArrayList<>();

        if (!gameInfo.isPresent()) {
            throw new ResourceNotFoundException("해당 경기가 존재 하지 않습니다.");
        }

        List<Vote> voteList = voteService.getVoteByGameId(gameIdx);
        List<NotVote> notVoteList = voteService.getNotVoteByGameId(gameIdx);


        for (Vote vote : voteList) {
            String team = vote.getMember().getTeam();
            if (team.equals("R")) {
                team1VoteList.add(vote.getMember());
            } else {
                team2VoteList.add(vote.getMember());
            }
        }

        for (NotVote notVote : notVoteList) {
            String team = notVote.getMember().getTeam();
            if (team.equals("R")) {
                team1NotVoteList.add(notVote.getMember());
            } else {
                team2NotVoteList.add(notVote.getMember());
            }
        }

        memberList.removeAll(team1VoteList);
        memberList.removeAll(team2VoteList);
        memberList.removeAll(team1NotVoteList);
        memberList.removeAll(team2NotVoteList);


        for (Member member : memberList) {
            String team = member.getTeam();

            if (team.equals("R")) {
                team1NoVoteList.add(member);
            } else {
                team2NoVoteList.add(member);
            }
        }


        result.put("gameInfo", gameInfo);
        result.put("vote", voteList);
        result.put("notVote", notVoteList);
        result.put("team1VoteList", team1VoteList);
        result.put("team2VoteList", team2VoteList);
        result.put("team1NotVoteList", team1NotVoteList);
        result.put("team2NotVoteList", team2NotVoteList);
        result.put("team1NoVoteList", team1NoVoteList);
        result.put("team2NoVoteList", team2NoVoteList);


        return new ResponseEntity<>(new Response<>(StatusEnum.OK, true, result), HttpStatus.OK);

    }

    @GetMapping(value = "/games:distance/{gameIdx}", produces = "application/json")
    public ResponseEntity<?> selectLastGameDistance(@PathVariable Integer gameIdx, CheckInDTO req) {
        Double result = gameService.getGameDistance(gameIdx, req);
        return new ResponseEntity<>(new Response<>(StatusEnum.OK, true, result), HttpStatus.OK);
    }


}
