import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class SecurityConfiguration21 {
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(new AntPathRequestMatcher("/user/login"));
    }
}