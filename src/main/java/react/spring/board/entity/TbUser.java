package react.spring.board.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TbUser implements UserDetails {
    private int idx;
    private String id;
    private String password;
    private String nickname;
    private String email;
    private String phoneNum;
    private String introduction;
    private ZonedDateTime createdDt;
    private ZonedDateTime modifiedDt;
    private ZonedDateTime deletedDt;
    private boolean emailVerified;
    private boolean authVerified;
    private boolean locked;
    private String role;
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(String.join("ROLE_", role)));
        return authorities;
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return locked;
    } // 계정의 만료 여부

    @Override
    public boolean isAccountNonLocked() {
        return locked;
    } // 계정의 잠김 여부

    @Override
    public boolean isCredentialsNonExpired() {
        return locked;
    } // 비밀번호 만료 여부

    @Override
    public boolean isEnabled() {
        return locked;
    } // 계정의 활성화 여부
}
