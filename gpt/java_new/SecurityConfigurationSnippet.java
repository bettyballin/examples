import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class SecurityConfigurationSnippet {
    public void configureHttpSecurity(HttpSecurity http) throws Exception {
        http.requestMatcher(new AntPathRequestMatcher("/"))
            .requestMatcher(new AntPathRequestMatcher("/login"));
    }
}