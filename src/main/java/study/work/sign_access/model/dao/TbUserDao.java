package study.work.sign_access.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TbUserDao {
    private int idx;
    private String id;
    private String password;
    private String name;
    private String email;
    private String phoneNum;
    private String introduction;
    private Instant createdDt;
    private Instant modifiedDt;
    private Instant deletedDt;
}
