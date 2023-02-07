package kr.co.ares.domain.dto;

import kr.co.ares.common.GeomUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Point;

@Setter
@Getter
@ToString
public class CheckInDTO {

    private Integer memberId;
    private Integer gameId;
    private Double lon;
    private Double lan;

}
