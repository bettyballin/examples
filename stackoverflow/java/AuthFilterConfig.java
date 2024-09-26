import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AuthFilterConfig {
    
    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }
}