package kr.co.ares.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class VoteDTO {

    @NotNull(message = "게임아이디는 필수 입니다")
    private Integer gameIdx;

    @NotNull(message = "게임아이디는 필수 입니다")
    private String memberId;

    @NotNull(message = "투표 여부는 필수 입니다.")
    private Boolean isVote;

}
