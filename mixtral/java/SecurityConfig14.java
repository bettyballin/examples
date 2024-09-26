import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // other configurations
            .exceptionHandling()
            .accessDeniedHandler(new CustomAccessDeniedHandler());
            // other configurations
    }

    private class CustomAccessDeniedHandler implements AccessDeniedHandler {
        @Override
        public void handle(javax.servlet.http.HttpServletRequest request, 
                           javax.servlet.http.HttpServletResponse response, 
                           org.springframework.security.access.AccessDeniedException accessDeniedException) 
                           throws java.io.IOException, javax.servlet.ServletException {
            // Custom access denied handling logic
            response.sendRedirect("/access-denied");
        }
    }
}