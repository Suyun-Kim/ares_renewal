package kr.co.ares.service;

import kr.co.ares.domain.CheckIn;
import kr.co.ares.domain.Game;
import kr.co.ares.domain.dto.CheckInDTO;
import kr.co.ares.infrastructure.CheckInRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.TimeZone;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckInService {

    private final CheckInRepository checkInRepository;

    public int insertCheckIn (CheckInDTO checkInDTO) {

        Instant instant = new Timestamp(System.currentTimeMillis()).toInstant();
        ZoneOffset offset = ZoneOffset.ofHours(9);
        OffsetDateTime date = instant.atOffset(offset);

        CheckIn checkIn = CheckIn.builder()
                .gameIdx(checkInDTO.getGameId())
                .memberIdx(checkInDTO.getMemberId())
                .checkInDate(date)
                .build();

        CheckIn res = checkInRepository.saveAndFlush(checkIn);

        return 0;
    }
}
