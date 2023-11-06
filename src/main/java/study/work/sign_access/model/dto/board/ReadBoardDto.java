package study.work.sign_access.model.dto.board;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;

@Data
@Builder
public class ReadBoardDto {
    private int id;
    private String title;
    private String content;
    private ZonedDateTime createdDt;
    private int authorId;
}
