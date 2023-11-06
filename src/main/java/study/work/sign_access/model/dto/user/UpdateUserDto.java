package study.work.sign_access.model.dto.user;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UpdateUserDto {
    private int idx;
    private String nickname;
    private String email;
    private String phoneNum;
    private String introduction;
}
