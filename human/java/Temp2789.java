import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.authentication.AuthenticationProvider;

public class Temp2789 {
    public static void main(String[] args) {
        // Application entry point
        System.out.println("Application started");
    }
}

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("my-path/**").hasAuthority("RELEVANT_AUTHORITY")
            .and()
            .httpBasic()
            .and()
            .authenticationProvider(new ClusterInternalAuthenticationProvider());
    }
}

class ClusterInternalAuthenticationProvider implements AuthenticationProvider {
    @Override
    public org.springframework.security.core.Authentication authenticate(org.springframework.security.core.Authentication authentication) throws org.springframework.security.core.AuthenticationException {
        // Implement authentication logic here
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // Define supported authentication class
        return true;
    }
}