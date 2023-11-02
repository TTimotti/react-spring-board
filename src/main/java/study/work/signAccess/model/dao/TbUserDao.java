package study.work.signAccess.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Builder
@Getter
public class TbUserDao {
    private int idx;
    private String id;
    private String password;
    private String name;
    private String email;
    private String phoneNum;
    private String introduction;
    private Timestamp createdDt;
    private Timestamp modifiedDt;
    private Timestamp deletedDt;
}
