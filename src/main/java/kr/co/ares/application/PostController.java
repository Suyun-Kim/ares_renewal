package kr.co.ares.application;

import kr.co.ares.domain.dto.NoticeDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class PostController {

    @PutMapping("/posts/notice")
    public ResponseEntity insertNoitce (@RequestBody NoticeDTO req) {

        log.info("req ::: " + req.toString());

        return null;

    }
}
