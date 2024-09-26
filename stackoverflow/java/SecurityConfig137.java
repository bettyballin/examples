import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig137urerAdapter;

@EnableWebSecurity
public class SecurityConfig137 extends WebSecurityConfig137urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin(formLogin -> formLogin
                .successHandler(new CustomAuthenticationSuccessHandler())
            );
    }
    
    // Assuming CustomAuthenticationSuccessHandler is defined elsewhere
    public class CustomAuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, org.springframework.security.core.Authentication authentication) throws java.io.IOException, javax.servlet.ServletException {
            // Handle success authentication here
        }
    }
}