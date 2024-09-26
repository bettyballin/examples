import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class Temp2053 extends WebSecurityConfigurerAdapter {
    
    public static void main(String[] args) {
        System.out.println("Application started");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // Other configurations
            .formLogin()
            .failureHandler(new CustomAuthenticationFailureHandler());
    }
    
    private static class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
        @Override
        public void onAuthenticationFailure(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, org.springframework.security.core.AuthenticationException exception) throws java.io.IOException, javax.servlet.ServletException {
            // Custom logic for authentication failure
            response.sendRedirect("/login?error");
        }
    }
}