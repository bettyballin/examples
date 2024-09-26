import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class Temp3038 {
    public static void main(String[] args) {
        // This main method is not necessary for Spring Security configuration
    }
}

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .successHandler(mySuccessHandler());
    }
    
    private AuthenticationSuccessHandler mySuccessHandler() {
        return (request, response, authentication) -> {
            // Custom logic here
            response.sendRedirect("/home");
        };
    }
}