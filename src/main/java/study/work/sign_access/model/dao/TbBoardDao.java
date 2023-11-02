package study.work.sign_access.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TbBoardDao {
    private int id;
    private String title;
    private String content;
    private Timestamp createdDt;
    private int authorId;
}
