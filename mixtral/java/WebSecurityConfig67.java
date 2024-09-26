import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletResponse;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ...

        http.exceptionHandling()
            .accessDeniedHandler((request, response, accessDeniedException) -> {
                if (new AntPathRequestMatcher("/api/v1/**").matches(request)) {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN);
                } else {
                    // Redirect to login page for non-API requests
                    response.sendRedirect("/login");
                }
            });

        // ...
    }
}