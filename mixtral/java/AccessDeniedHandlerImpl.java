import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.DefaultRedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import org.springframework.security.access.AccessDeniedException;

public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        String targetUrl = "/login?expired";

        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With")) || request.getAttribute("AJAX_REQUEST") != null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
        } else {
            redirectStrategy.sendRedirect(request, response, targetUrl);
        }
    }
}

// Configuration example to use AccessDeniedHandlerImpl

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .exceptionHandling()
                .accessDeniedHandler(new AccessDeniedHandlerImpl())
            .and()
            // other configurations...
    }
}