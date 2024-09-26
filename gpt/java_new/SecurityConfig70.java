import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.oauth2.provider.authentication.TokenEndpointAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig70urerAdapter;

public class SecurityConfig70 extends WebSecurityConfig70urerAdapter {

    private final AuthenticationManager authenticationManager;
    private final ClientDetailsService clientDetailsService;

    public SecurityConfig70(AuthenticationManager authenticationManager, ClientDetailsService clientDetailsService) {
        this.authenticationManager = authenticationManager;
        this.clientDetailsService = clientDetailsService;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            // ... other configuration ...
            .addFilterAfter(new TokenEndpointAuthenticationFilter(authenticationManager, new DefaultOAuth2RequestFactory(clientDetailsService)), UsernamePasswordAuthenticationFilter.class);
    }
}