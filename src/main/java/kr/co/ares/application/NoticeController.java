package kr.co.ares.application;

import kr.co.ares.common.Response;
import kr.co.ares.common.StatusEnum;
import kr.co.ares.domain.Notice;
import kr.co.ares.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping(value = "/notices", produces = "application/json")
    public ResponseEntity selectNotices (@PageableDefault(sort = "createDate", direction = Sort.Direction.DESC)Pageable pageable) {

        Page<Notice> notices = noticeService.getNotices(pageable);

        return new ResponseEntity(new Response<>(StatusEnum.OK, true, notices), HttpStatus.OK);
    }
}
