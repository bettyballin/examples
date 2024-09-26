import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;

import java.util.Collections;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your other configurations go here.

        JwtAuthenticationProvider authenticationProvider = new JwtAuthenticationProvider();
        http.oauth2ResourceServer().authenticationManager(new ProviderManager(Collections.singletonList(authenticationProvider)));
    }
}