package kr.co.ares.service;

import kr.co.ares.domain.Notice;
import kr.co.ares.infrastructure.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<Notice> getNoticeTop3 () {
        return noticeRepository.findTop3ByOrderByIdxDesc();
    }

}
