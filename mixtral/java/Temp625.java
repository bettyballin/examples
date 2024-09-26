import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpointAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationManager authenticationManager;

    public SecurityConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .antMatcher("/oauth/**")
                .authorizeRequests().anyRequest().authenticated()
                    .and()
                .httpBasic();

        TokenEndpointAuthenticationFilter tokenEndpointAuthFilter = new TokenEndpointAuthenticationFilter(
          authenticationManager, new DefaultAuthorizationRequestFactory());

        http.addFilterAfter(tokenEndpointAuthFilter, BasicAuthenticationFilter.class);
        // @formatter:on
    }

    private static class DefaultAuthorizationRequestFactory {
        // Dummy class for demonstration purposes
    }
}