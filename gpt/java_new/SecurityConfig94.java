import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig94urerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig94 extends WebSecurityConfig94urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Define your security configuration here
    }

    public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                            org.springframework.security.core.Authentication authentication) throws IOException {
            String username = authentication.getName();
            response.sendRedirect("/welcome/" + username);
        }
    }
}