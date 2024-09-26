import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class CustomUsernamePasswordAuthenticationFilter1 extends UsernamePasswordAuthenticationFilter {
    public CustomUsernamePasswordAuthenticationFilter1() {
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "GET"));
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        return request.getParameter("username");
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        return request.getParameter("password");
    }
}