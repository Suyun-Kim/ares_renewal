package kr.co.ares.service;

import kr.co.ares.domain.MatchResult;
import kr.co.ares.infrastructure.MatchResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class MatchResultService {

    private final MatchResultRepository matchResultRepository;

    public List<MatchResult> getListMatchTop3 () {

        return matchResultRepository.findTop3ByOrderByIdxDesc();
    }
}
