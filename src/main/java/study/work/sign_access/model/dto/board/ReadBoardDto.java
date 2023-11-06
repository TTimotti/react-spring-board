package study.work.sign_access.model.dto.board;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Data
@Builder
public class ReadBoardDto {
    private int id;
    private String title;
    private String content;
    private Instant createdDt;
    private int authorId;
}
