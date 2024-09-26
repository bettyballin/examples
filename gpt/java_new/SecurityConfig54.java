import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.access.AccessDeniedHandler;

public class SecurityConfig54 {

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configuration ...
            .exceptionHandling()
            .accessDeniedHandler(accessDeniedHandler())
            .and();
            // ... other configuration ...
    }

    // Inner class or a separate class if needed
    private class CustomAccessDeniedHandler implements AccessDeniedHandler {
        @Override
        public void handle(...) {
            // handle method implementation
        }
    }
}