package study.work.sign_access.model.dto.board;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class ReadBoardDto {
    private int id;
    private String title;
    private String content;
    private Timestamp createdDt;
    private int authorId;
}
