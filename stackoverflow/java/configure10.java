import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// Inside a configuration class that extends WebSecurityConfigurerAdapter or similar
public void configure10(HttpSecurity http) throws Exception {
    http
        .authorizeRequests(authz -> authz
            .anyRequest().authenticated()
        )
        .oauth2ResourceServer(oauth2 -> oauth2
            .jwt(Customizer.withDefaults())
        );
}