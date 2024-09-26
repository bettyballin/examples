import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class SecurityConfig101 {
    public void configure(HttpSecurity httpSecurity) throws Exception {
        RequestHeaderRequestMatcher headerMatcher = 
            new RequestHeaderRequestMatcher("X-Operation-Name", "forgot-password");
        
        AntPathRequestMatcher antRequestMatcher = 
            new AntPathRequestMatcher("/api/website-user", HttpMethod.POST.name());

        AndRequestMatcher andMatcher = 
            new AndRequestMatcher(headerMatcher, antRequestMatcher);

        httpSecurity.authorizeRequests()
            .requestMatchers(andMatcher)
            .permitAll();
    }
}