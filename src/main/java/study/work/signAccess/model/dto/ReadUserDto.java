package study.work.signAccess.model.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
@Data
@Builder
public class ReadUserDto {
    private int id;
    private String name;
    private String introduction;
    private Timestamp createdDt;
}
