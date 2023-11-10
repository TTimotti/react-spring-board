package react.spring.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TbBoard {
    private int id;
    private String title;
    private String content;
    private ZonedDateTime createdDt;
    private int authorId;
}
