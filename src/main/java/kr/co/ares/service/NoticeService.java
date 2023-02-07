package kr.co.ares.service;

import kr.co.ares.domain.Notice;
import kr.co.ares.infrastructure.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<Notice> getNoticeTop3 () {
        return noticeRepository.findTop3ByOrderByIdxDesc();
    }

    public Page<Notice> getNotices (Pageable pageable) {
        Page<Notice> notices = noticeRepository.findAll(pageable);

        return notices;
    }

}
