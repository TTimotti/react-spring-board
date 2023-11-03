package study.work.sign_access.model.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;

@Data
@Builder
public class SelectUserDto implements UserDetails {
    private int idx;
    private String id;
    private String password;
    private String name;
    private String email;
    private String phoneNum;
    private String introduction;
    @JsonFormat(timezone = "Asia/Seoul")
    private Timestamp createdDt;
    @JsonFormat(timezone = "Asia/Seoul")
    private Timestamp modifiedDt;
    @JsonFormat(timezone = "Asia/Seoul")
    private Timestamp deletedDt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
