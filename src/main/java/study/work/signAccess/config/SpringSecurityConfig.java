package study.work.signAccess.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean // 메소드 이름은 반드시 filterChain 으로 설정
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf() // CSRF, CORS 기능 OFF
                .disable()
            .cors()
                .disable()
            .authorizeHttpRequests()
                .anyRequest()
                    .permitAll()
            .and()
                .formLogin()
                    .loginPage("/index");

//        http // https://velog.io/@wooyong99/Spring-Security
//            .formLogin()
//                .loginPage("/login")

        ;


        return http.build();
    }
}
