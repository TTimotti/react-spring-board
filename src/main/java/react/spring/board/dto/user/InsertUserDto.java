package react.spring.board.dto.user;

import lombok.Data;

@Data
public class InsertUserDto {
    private String id;
    private String password;
    private String nickname;
    private String email;
    private String phoneNum;
    private String introduction;
}
