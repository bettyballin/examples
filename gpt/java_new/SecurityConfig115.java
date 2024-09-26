import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig115 {

    private static final String HEALTHCHECK_USERNAME = "healthCheckMonitoring";
    private static final String HEALTHCHECK_PASSWORD = "healthPassword";
    private static final String HEALTHCHECK_ROLE = "HEALTHCHECK";

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser(HEALTHCHECK_USERNAME)
            .password("{noop}" + HEALTHCHECK_PASSWORD)
            .roles(HEALTHCHECK_ROLE);
    }
}