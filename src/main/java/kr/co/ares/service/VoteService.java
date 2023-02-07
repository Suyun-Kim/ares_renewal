package kr.co.ares.service;

import kr.co.ares.domain.NotVote;
import kr.co.ares.domain.Vote;
import kr.co.ares.domain.dto.VoteDTO;
import kr.co.ares.infrastructure.NotVoteRepository;
import kr.co.ares.infrastructure.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final NotVoteRepository notVoteRepository;

    public Page<Vote> findAll (Pageable pageable) {
        return voteRepository.findAll(pageable);
    }

    public Integer addVoteMember(VoteDTO voteDTO) {

        Optional<Vote> voteInfo = voteRepository.findByGameIdxAndMemberIdx(voteDTO.getGameIdx(), voteDTO.getMemberIdx());
        Optional<NotVote> notVoteInfo = notVoteRepository.findByGameIdxAndMemberIdx(voteDTO.getGameIdx(), voteDTO.getMemberIdx());

        if (voteInfo.isPresent()) {
            return 20;
        }

        notVoteInfo.ifPresent(notVoteRepository::delete);

        LocalDateTime localDateTime = LocalDateTime.now();

        Vote vote = Vote.builder()
                .gameIdx(voteDTO.getGameIdx())
                .memberIdx(voteDTO.getMemberIdx())
                .createDate(Timestamp.valueOf(localDateTime))
                .build();

        voteRepository.saveAndFlush(vote);

        return 0;

    }

    public Integer addNotVoteMember (VoteDTO voteDTO) {

        Optional<Vote> voteInfo = voteRepository.findByGameIdxAndMemberIdx(voteDTO.getGameIdx(), voteDTO.getMemberIdx());
        Optional<NotVote> notVoteInfo = notVoteRepository.findByGameIdxAndMemberIdx(voteDTO.getGameIdx(), voteDTO.getMemberIdx());

        if (notVoteInfo.isPresent()) {
            return 20;
        }

        voteInfo.ifPresent(voteRepository::delete);

        LocalDateTime localDateTime = LocalDateTime.now();

        NotVote notVote = NotVote.builder()
                .gameIdx(voteDTO.getGameIdx())
                .memberIdx(voteDTO.getMemberIdx())
                .createDate(Timestamp.valueOf(localDateTime))
                .build();

        notVoteRepository.saveAndFlush(notVote);

        return 0;

    }

    public List<Vote> getVoteByGameId (Integer gameId) {
        return voteRepository.findByGameIdx(gameId);
    }

    public List<NotVote> getNotVoteByGameId (Integer gameId) {
        return notVoteRepository.findByGameIdx(gameId);

    }
}
