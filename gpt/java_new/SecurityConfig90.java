import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig90urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig90 extends WebSecurityConfig90urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requiresChannel()
            .anyRequest()
            .requiresSecure()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint((request, response, authException) -> {
                if (!request.isSecure()) {
                    response.setStatus(HttpServletResponse.SC_UPGRADE_REQUIRED);
                } else {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Required");
                }
            });
    }
}