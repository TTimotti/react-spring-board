package study.work.signAccess.model.dto.user;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import study.work.signAccess.model.util.Pagination;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Data
@Builder
public class SelectUserListDto {
    List<SelectUserDto> userList;
    private Pagination pagination;
}
