import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Config1uration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Config1uration
@EnableWebSecurity
public class Config1 {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/unprotected", "/endpoints/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin();
        return http.build();
    }
}