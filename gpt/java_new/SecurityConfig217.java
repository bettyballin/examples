import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig217 {

    @Bean
    public SecurityFilterChain coreApiFilterChain(HttpSecurity http) throws Exception {
        http
            .antMatcher("/api/core/**")
            .authorizeRequests()
            .anyRequest().permitAll();
        
        return http.build();
    }

    @Bean
    public SecurityFilterChain moduleApiFilterChain(HttpSecurity http) throws Exception {
        http
            .antMatcher("/api/module2/**")
            .authorizeRequests()
            .anyRequest().permitAll();
        
        return http.build();
    }
}