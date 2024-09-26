import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class Temp3397 {
    public static void main(String[] args) {
        // This is just a placeholder main method
        // In a real application, Spring Boot would handle the Security configuration
    }
}

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin(formLogin -> formLogin
                .successHandler(new CustomAuthenticationSuccessHandler())
            );
    }
}

class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest request,
                                        javax.servlet.http.HttpServletResponse response,
                                        org.springframework.security.core.Authentication authentication)
            throws java.io.IOException, javax.servlet.ServletException {
        // Custom success handler logic
        response.getWriter().append("Authentication Success!");
        response.setStatus(200);
    }
}