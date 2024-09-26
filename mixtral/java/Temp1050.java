import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

public class Temp1050 {
    public static void main(String[] args) {
        // Main method can be left empty for Spring Boot applications
    }
}

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/some/endpoint").access("hasRole('ROLE_USER')")
            .requestMatcher(new IgnoreTrailingSlashRequestMatcher());
    }
}

class IgnoreTrailingSlashRequestMatcher implements RequestMatcher {
    @Override
    public boolean matches(HttpServletRequest request) {
        String path = request.getServletPath();
        return path != null && (path.endsWith("/") || path.endsWith("/some/endpoint"));
    }
}