import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp223 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Spring Boot will automatically run the security configuration class
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationSuccessHandler customAuthSuccessHandler = new CustomAuthenticationSuccessHandler();

        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .failureUrl("/login")
                .successHandler(customAuthSuccessHandler)
                .and()
            .logout()
                .permitAll();
    }
    
    public static class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
            // Custom success handler logic
            response.sendRedirect("/home");
        }
    }
}