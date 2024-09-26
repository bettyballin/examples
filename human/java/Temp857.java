import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlStrategy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

@Configuration
public class SecurityConfig {

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public ConcurrentSessionControlStrategy sas(SessionRegistry sessionRegistry) {
        ConcurrentSessionControlStrategy strategy = new ConcurrentSessionControlStrategy(sessionRegistry);
        strategy.setMaximumSessions(1);
        strategy.setExceptionIfMaximumExceeded(true);
        return strategy;
    }
}