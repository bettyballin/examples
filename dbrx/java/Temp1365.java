import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class Temp1365 {
    public static void main(String[] args) {
        // This is just a placeholder for the main method.
        // The actual Spring Security configuration will be in the SecurityConfig class.
    }
}

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
            .successHandler(new CustomLoginSuccessHandler())
            .and()
            .authorizeRequests()
            .anyRequest().authenticated();
    }
}

class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest request,
                                        javax.servlet.http.HttpServletResponse response,
                                        org.springframework.security.core.Authentication authentication) throws java.io.IOException, javax.servlet.ServletException {
        // Custom logic for login success
        response.sendRedirect("/home");
    }
}