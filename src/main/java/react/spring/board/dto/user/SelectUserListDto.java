package react.spring.board.dto.user;

import lombok.Builder;
import lombok.Data;
import react.spring.board.common.Pagination;

import java.util.List;

@Data
@Builder
public class SelectUserListDto {
    List<SelectUserDto> userList;
    private Pagination pagination;
}
