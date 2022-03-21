package kr.co.ares.service;

import kr.co.ares.domain.Vote;
import kr.co.ares.domain.dto.VoteDTO;
import kr.co.ares.infrastructure.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;

    public Page<Vote> findAll (Pageable pageable) {
        return voteRepository.findAll(pageable);
    }

    public Vote addVoteMember(VoteDTO voteDTO) {

        LocalDateTime localDateTime = LocalDateTime.now();

        Vote vote = Vote.builder()
                .gameIdx(voteDTO.getGameIdx())
                .memberIdx(voteDTO.getMemberIdx())
                .isVote(voteDTO.getIsVote())
                .createDate(Timestamp.valueOf(localDateTime))
                .build();

        return voteRepository.saveAndFlush(vote);

    }
}
