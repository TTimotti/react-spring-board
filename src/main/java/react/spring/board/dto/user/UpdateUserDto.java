package react.spring.board.dto.user;

import lombok.Data;

@Data
public class UpdateUserDto {
    private int idx;
    private String nickname;
    private String email;
    private String phoneNum;
    private String introduction;
}
