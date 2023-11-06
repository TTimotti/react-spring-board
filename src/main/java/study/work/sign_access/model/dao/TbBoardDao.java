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
public class TbBoardDao {
    private int id;
    private String title;
    private String content;
    private Instant createdDt;
    private int authorId;
}
