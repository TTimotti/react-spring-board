package study.work.signAccess.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Builder
@Getter
public class TbBoardDao {
    private int id;
    private String title;
    private String content;
    private Timestamp createdDt;
    private int authorId;
}
