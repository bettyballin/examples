import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp3508 {
    public static void main(String[] args) throws Exception {
        HttpSecurity http = new HttpSecurity(null, null, null, null, null, null, null);
        http.csrf(csrf -> csrf.requireCsrfProtectionMatcher(new MyBrowserRequestMatcher()));
    }
}

class MyBrowserRequestMatcher implements org.springframework.security.web.util.matcher.RequestMatcher {
    @Override
    public boolean matches(HttpServletRequest request) {
        // Custom logic to match requests that require CSRF protection
        return request.getHeader("User-Agent").contains("Mozilla");
    }
}