import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ...

        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")

            .and().exceptionHandling()

            // This is where you specify the custom access denied handler

                .accessDeniedHandler(new AccessDeniedHandlerImpl());

        // ...
    }

}

class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       org.springframework.security.access.AccessDeniedException accessDeniedException) throws IOException, ServletException {

        // Here you can redirect to the logout URL

        String url = "/salirpafuera";

        if (response.isCommitted()) {
            return;
        }

        response.sendRedirect(url);
    }

}