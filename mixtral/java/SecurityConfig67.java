import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${oauthEnabled}")
    private boolean oauthEnabled;

    // ...

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (oauthEnabled) {
            // Configure OAuth2
            http.authorizeRequests()
                .antMatchers("/api/**").authenticated();

            ResourceServerTokenServices tokenService = new CustomUserAuthenticationConverter();

            http
              .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());

            // Additional OAuth2 configurations
            // ...

        } else {
            // Configure Basic Authentication
            http.authorizeRequests()
                .antMatchers("/api/**").authenticated();

            http
              .httpBasic();

            // Additional Basic Auth configurations
            // ...
        }
    }
}