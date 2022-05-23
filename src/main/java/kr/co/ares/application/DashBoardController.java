package kr.co.ares.application;

import kr.co.ares.common.Response;
import kr.co.ares.common.StatusEnum;
import kr.co.ares.domain.Game;
import kr.co.ares.domain.MatchResult;
import kr.co.ares.domain.Notice;
import kr.co.ares.domain.Vote;
import kr.co.ares.service.GameService;
import kr.co.ares.service.MatchResultService;
import kr.co.ares.service.NoticeService;
import kr.co.ares.service.VoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
public class DashBoardController {

    private final GameService gameService;
    private final VoteService voteService;
    private final NoticeService noticeService;
    private final MatchResultService matchResultService;

    @GetMapping(value = "/dashboards/game", produces = "application/json")
    public ResponseEntity selectGameSchedule () {

        int voteCount = 0;
        int notVoteCount = 0;

        Game game = gameService.getGameLast();
        List<Vote> votes = voteService.getVoteByGameId(game.getIdx());
        for (Vote vote : votes) {
            if (vote.isVote()) {
                voteCount++;
            } else {
                notVoteCount++;
            }
        }

        game.setVoteCount(voteCount);
        game.setNotVoteCount(notVoteCount);

        return new ResponseEntity(new Response<>(StatusEnum.OK, true, game), HttpStatus.OK);

    }

    @GetMapping(value = "/dashboards/notice", produces = "application/json")
    public ResponseEntity selectNoticeTop3 () {

        List<Notice> notices = noticeService.getNoticeTop3();

        return new ResponseEntity(new Response<>(StatusEnum.OK, true, notices), HttpStatus.OK);

    }

    @GetMapping(value = "/dashboards/match", produces = "application/json")
    public ResponseEntity selectLastMatchTop3 () {
        List<MatchResult> matchResults = matchResultService.getListMatchTop3();

        return new ResponseEntity(new Response<>(StatusEnum.OK, true, matchResults), HttpStatus.OK);
    }
}


