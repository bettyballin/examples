import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response,
                          Authentication authentication) throws IOException, ServletException {
        // Custom logic here
    }
}

// Assume this is defined in a @Configuration annotated class
class SecurityConfig {

    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler() {
        return new AppAuthenticationSuccessHandler();
    }

    // Method to configure HttpSecurity (assuming it's within a properly annotated class)
    public void configureHttpSecurity(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .successHandler(appAuthenticationSuccessHandler())
                .failureHandler(new AppAuthenticationFailureHandler()); // Assuming AppAuthenticationFailureHandler is defined elsewhere
    }
}