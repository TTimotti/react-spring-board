package study.work.sign_access.model.dto.user;

import lombok.Builder;
import lombok.Data;
import study.work.sign_access.model.util.Pagination;

import java.util.List;

@Data
@Builder
public class SelectUserListDto {
    List<SelectUserDto> userList;
    private Pagination pagination;
}
