package kr.co.ares.service;


import kr.co.ares.domain.GameNotVote;
import kr.co.ares.domain.GameVote;
import kr.co.ares.domain.Member;
import kr.co.ares.domain.Schedule;
import kr.co.ares.domain.dto.VoteDTO;
import kr.co.ares.infrastructure.GameNotVoteRepository;
import kr.co.ares.infrastructure.GameVoteRepository;

import kr.co.ares.infrastructure.MemberRepository;
import kr.co.ares.infrastructure.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class VoteService {

    private final GameVoteRepository gameVoteRepository;
    private final GameNotVoteRepository gameNotVoteRepository;
    private final MemberRepository memberRepository;
    private final ScheduleRepository scheduleRepository;

    public Integer addCurrentGameVote(VoteDTO voteDTO) {

        if (voteDTO.getIsVote()) {

            GameVote gameVote = gameVoteRepository.findByPlayIdxAndMemberId(voteDTO.getGameIdx(), voteDTO.getMemberId());
            GameNotVote gameNotVote = gameNotVoteRepository.findByPlayIdxAndMemberId(voteDTO.getGameIdx(), voteDTO.getMemberId());

            if (gameNotVote != null) {
                gameNotVoteRepository.deleteById(gameNotVote.getVoteIdx());
            }

            if (gameVote != null) {
                return 40;
            }

            GameVote vote = new GameVote();

            vote.setPlayIdx(voteDTO.getGameIdx());
            vote.setMemberId(voteDTO.getMemberId());
            vote.setAttendance_time(null);

            gameVoteRepository.saveAndFlush(vote);


        } else {

            GameNotVote gameNotVote = gameNotVoteRepository.findByPlayIdxAndMemberId(voteDTO.getGameIdx(), voteDTO.getMemberId());
            GameVote gameVote = gameVoteRepository.findByPlayIdxAndMemberId(voteDTO.getGameIdx(), voteDTO.getMemberId());

            if (gameVote != null) {
                gameVoteRepository.deleteById(gameVote.getVoteIdx());
            }

            if (gameNotVote != null) {
                return 40;
            }

            GameNotVote notVote = new GameNotVote();

            notVote.setPlayIdx(voteDTO.getGameIdx());
            notVote.setMemberId(voteDTO.getMemberId());
            notVote.setCreateDate(new Timestamp(System.currentTimeMillis()));

            gameNotVoteRepository.saveAndFlush(notVote);

        }

        return 0;
    }

    public Map<String, Object> getCurrentScheduleVoteList() {

        Map<String, Object> result = new HashMap<>();
        Schedule schedule = scheduleRepository.findFirstByOrderByPlayIndexDesc();
        List<Member> memberList = memberRepository.findAll();
        List<GameVote> gameVote = gameVoteRepository.findByPlayIdx(schedule.getPlayIndex());
        List<GameNotVote> gameNotVote = gameNotVoteRepository.findByPlayIdx(schedule.getPlayIndex());
        List<Member> teamSGameVote = new ArrayList<>();
        List<Member> teamRGameVote = new ArrayList<>();
        List<Member> teamSGameNotVote = new ArrayList<>();
        List<Member> teamRGameNotVote = new ArrayList<>();
        List<Member> teamSGameNoVote = new ArrayList<>();
        List<Member> teamRGameNoVote = new ArrayList<>();


        int teamSVoteCount = 0;
        int teamRVoteCount = 0;
        int teamSNotVoteCount = 0;
        int teamRNotVoteCount = 0;
        int teamSNoVoteCount = 0;
        int teamRNoVoteCount = 0;

        for (GameVote vote : gameVote) {
            Optional<Member> member = memberRepository.findByMemberId(vote.getMemberId());
            vote.setMemberTeam(member.get().getTeam());

            if (member.get().getTeam().equals("S")) {
                teamSVoteCount++;
                teamSGameVote.add(member.get());

            } else if (member.get().getTeam().equals("R")) {
                teamRVoteCount++;
                teamRGameVote.add(member.get());
            }

            memberList.remove(member.get());
        }

        for (GameNotVote notVote : gameNotVote) {
            Optional<Member> member = memberRepository.findByMemberId(notVote.getMemberId());
            notVote.setMemberTeam(member.get().getTeam());

            if (member.get().getTeam().equals("S")) {
                teamSNotVoteCount++;
                teamSGameNotVote.add(member.get());

            } else if (member.get().getTeam().equals("R")) {
                teamRNotVoteCount++;
                teamSGameNotVote.add(member.get());
            }

            memberList.remove(member.get());
        }

        for (Member member : memberList) {
            if (member.getTeam().equals("S")) {
                teamSNoVoteCount++;
                teamSGameNoVote.add(member);
            } else if (member.getTeam().equals("R")) {
                teamRNoVoteCount++;
                teamRGameNoVote.add(member);
            }
        }


        result.put("teamSGameVote", teamSGameVote);
        result.put("teamRGameVote", teamRGameVote);
        result.put("teamSGameNotVote", teamSGameNotVote);
        result.put("teamRGameNotVote", teamRGameNotVote);
        result.put("teamSGameNoVote", teamSGameNoVote);
        result.put("teamRGameNoVote", teamRGameNoVote);
        result.put("teamSVoteCount", teamSVoteCount);
        result.put("teamRVoteCount", teamRVoteCount);
        result.put("teamSNotVoteCount", teamSNotVoteCount);
        result.put("teamRNotVoteCount", teamRNotVoteCount);
        result.put("teamSNoVoteCount", teamSNoVoteCount);
        result.put("teamRNoVoteCount", teamRNoVoteCount);

        return result;
    }

    public Map<String, Object> getCurrentScheduleVoteCount() {

        Map<String, Object> result = new HashMap<>();
        Schedule schedule = scheduleRepository.findFirstByOrderByPlayIndexDesc();

        List<Member> memberList = memberRepository.findAll();
        List<GameVote> gameVote = gameVoteRepository.findByPlayIdx(schedule.getPlayIndex());
        List<GameNotVote> gameNotVote = gameNotVoteRepository.findByPlayIdx(schedule.getPlayIndex());

        result.put("memberCount", memberList.size());
        result.put("voteCount", gameVote.size());
        result.put("notVoteCount", gameNotVote.size());
        result.put("noVoteCount", (memberList.size() - ( gameVote.size() + gameNotVote.size() )));

        return result;
    }


}
