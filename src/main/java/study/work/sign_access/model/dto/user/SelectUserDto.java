package study.work.sign_access.model.dto.user;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;

@Data
@Builder
public class SelectUserDto {
    private int idx;
    private String id;
    private String name;
    private String email;
    private String phoneNum;
    private String introduction;
    private Instant createdDt;
    private Instant modifiedDt;
    private Instant deletedDt;
}
