import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;

@Configuration
public class SecurityConfig {

    @Bean
    public SessionFixationProtectionStrategy sessionFixationProtectionStrategy() {
        SessionFixationProtectionStrategy strategy = new SessionFixationProtectionStrategy();
        strategy.setMigrateSessionAttributes(false);
        return strategy;
    }
}