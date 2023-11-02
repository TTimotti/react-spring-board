package study.work.sign_access.model.dto.user;

import lombok.Data;
import study.work.sign_access.model.dao.TbUserDao;

@Data
public class InsertUserDto {
    private String id;
    private String password;
    private String name;
    private String email;
    private String phoneNum;
    private String introduction;
}
