import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig44urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig44 extends WebSecurityConfig44urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new CustomAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    }
    
    // Assuming CustomAuthenticationFilter class exists and has a constructor that accepts AuthenticationManager
    public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
        public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
            super.setAuthenticationManager(authenticationManager);
        }
    }
}