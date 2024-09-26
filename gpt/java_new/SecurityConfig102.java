import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig102urerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

public class SecurityConfig102 extends WebSecurityConfig102urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... Your other configuration ...
            .exceptionHandling()
            .accessDeniedHandler(accessDeniedHandler()) // Register your custom access denied handler here
            .and();
            // ... Rest of your configuration ...
    }

    private AccessDeniedHandler accessDeniedHandler() {
        // Implementation of your custom AccessDeniedHandler
        return (request, response, accessDeniedException) -> {
            // Your custom access denied handling logic here
        };
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/page_403.jsp"); // Exclude the custom error page from security
    }

    // ... Rest of your security configuration class ...
}