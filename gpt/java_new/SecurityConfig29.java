import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig29urerAdapter;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

public class SecurityConfig29 extends WebSecurityConfig29urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true)
                .expiredSessionStrategy(expiredSessionStrategy())
                .and()
            .sessionAuthenticationStrategy(sessionAuthenticationStrategy());
    }

    private SessionInformationExpiredStrategy expiredSessionStrategy() {
        return event -> {
            throw new SessionAuthenticationException("Your session has expired.");
        };
    }

    private SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return authentication -> {
            // Custom session authentication strategy logic
        };
    }
}