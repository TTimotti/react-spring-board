package study.work.signAccess.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Builder
@Getter
public class TbUserDao {
    private int id;
    private String name;
    private String introduction;
    private Timestamp createdDt;
}
