package react.spring.board.dto.user;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Builder
public class SelectUserDto {
    private int idx;
    private String id;
    private String nickname;
    private String email;
    private String phoneNum;
    private String introduction;
    private ZonedDateTime createdDt;
    private ZonedDateTime modifiedDt;
}
