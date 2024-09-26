import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;

public class SecurityConfig {

    public void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .disable()
            // ...
            .and()
            .addFilterBefore(
                    new XHeaderAuthenticationFilter(), 
                    UsernamePasswordAuthenticationFilter.class
            );
    }
    
    private class XHeaderAuthenticationFilter extends CsrfFilter {
        public XHeaderAuthenticationFilter() {
            super(request -> false); // Example, implement your filter logic here
        }
    }
}