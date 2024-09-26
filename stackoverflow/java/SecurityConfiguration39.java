import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class SecurityConfiguration39 {
    public void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/api/**")
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/api/user").permitAll()
                    .anyRequest().hasRole("USER");
    }
}