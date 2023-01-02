package kr.co.ares.application;

import kr.co.ares.common.Response;
import kr.co.ares.common.StatusEnum;
import kr.co.ares.domain.Game;
import kr.co.ares.domain.Member;
import kr.co.ares.domain.Vote;
import kr.co.ares.service.GameService;
import kr.co.ares.service.MemberService;
import kr.co.ares.service.VoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Log4j2
@RestController
@RequiredArgsConstructor
public class GameController {

    private final MemberService memberService;
    private final GameService gameService;
    private final VoteService voteService;

    @GetMapping(value = "/games", produces = "application/json")
    public ResponseEntity selectVotedGameInfo() {

        int voteCount = 0;
        int notVoteCount = 0;
        int noVoteCount = 0;

        Game game = gameService.getVotedGameInfo(false);
        List<Vote> votes = voteService.getVoteByGameId(game.getIdx());
        List<Member> members = memberService.getAllVoteMember();

        List<Member> voteMembers = new ArrayList<>();
        List<Member> notVoteMembers = new ArrayList<>();

        for (Vote vote : votes) {
            if (vote.isVote()) {
                voteCount++;
                voteMembers.add(vote.getMember());
                members.remove(vote.getMember());
            } else {
                notVoteCount++;
                notVoteMembers.add(vote.getMember());
                members.remove(vote.getMember());
            }
        }

        noVoteCount = members.size() - (voteCount + notVoteCount);

        game.setVoteCount(voteCount);
        game.setNotVoteCount(notVoteCount);
        game.setNoVoteCount(noVoteCount);
        game.setVoteMembers(voteMembers);
        game.setNotVoteMembers(notVoteMembers);
        game.setNoVoteMembers(members);


        return new ResponseEntity(new Response<>(StatusEnum.OK, true, game), HttpStatus.OK);
    }


}
