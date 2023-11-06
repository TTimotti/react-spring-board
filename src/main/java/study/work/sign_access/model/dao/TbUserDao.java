package study.work.sign_access.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TbUserDao implements UserDetails {
    private int idx;
    private String id;
    private String password;
    private String nickname;
    private String email;
    private String phoneNum;
    private String introduction;
    private Instant createdDt;
    private Instant modifiedDt;
    private Instant deletedDt;
    private boolean emailVerified;
    private boolean authVerified;
    private boolean locked;
    private Collection<GrantedAuthority> authorities;
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return id;
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
