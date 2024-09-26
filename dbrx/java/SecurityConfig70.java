import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    @Order(1)
    public static class OAuth2SSOConfig extends WebSecurityConfigurerAdapter {
        // Configure your SSO settings here

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/sso/**")
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
        }
    }

    @Configuration
    public static class TokenAuthConfig extends WebSecurityConfigurerAdapter {
        // Configure your token-based authentication settings here

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/api/**")
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer();
        }
    }

}