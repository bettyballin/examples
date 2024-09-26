import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig5urerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

public class WebSecurityConfig5 extends WebSecurityConfig5urerAdapter {

    @Autowired
    private SessionRegistry sessionRegistry;

    public int countActiveUsers() {
        return sessionRegistry.getAllPrincipals().size();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... your configuration
            .and()
            .sessionManagement()
            .maximumSessions(-1)
            .sessionRegistry(sessionRegistry());
    }
}