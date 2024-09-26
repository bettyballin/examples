import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class SecurityConfig {
    
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)
            .requestMatchers(new NegatedRequestMatcher(
                new AntPathRequestMatcher("/some_endpoint")
            ));
    }
    
    public BasicAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new BasicAuthenticationFilter(authenticationManager());
    }
    
    // Placeholder method to simulate authenticationManager() method
    private Object authenticationManager() {
        return new Object();
    }
}