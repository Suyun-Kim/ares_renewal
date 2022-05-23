package kr.co.ares.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class NoticeDTO {

    @NotNull
    private String title;

    @NotNull
    private String content;

    private Integer Writer;
    private Timestamp createDate;

}
