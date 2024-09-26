import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

public class SecurityConfig134 {

    // Assuming this is within a method context, such as 'configure' of a security configuration class
    public void configure(HttpSecurity http) throws Exception {
        http
            .logout()
            .invalidateHttpSession(true)
            .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK));
    }
}