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
    private Long gameIdx;

    @NotNull(message = "게임아이디는 필수 입니다")
    private Long memberIdx;

    @NotNull(message = "투표 여부는 필수 입니다.")
    private Boolean isVote;

}
