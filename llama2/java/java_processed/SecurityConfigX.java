import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@Profile("x-env")
public class SecurityConfigX extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomAuthenticationProvider cap;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure HTTP security for scenario X
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return new ProviderManager(Arrays.asList(cap));
    }
}

// Assuming CustomAuthenticationProvider is defined elsewhere
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

class CustomAuthenticationProvider implements AuthenticationProvider {
    // Implementation of CustomAuthenticationProvider
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Custom authentication logic
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // Supports specific authentication type
        return true;
    }
}