import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_WHITELIST = { "/docs/**", "/csrf/**" };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure JWT-based security for specific endpoints
        http.antMatcher("/abc/**")
            .authorizeRequests()
            .anyRequest().hasAuthority("ABC");

        http.antMatcher("/ddd/**").authorizeRequests().anyRequest().hasAuthority("DDD");

        // Configure basic authentication for actuator endpoints
        HttpSecurity adminHttp = http
            .antMatcher("/actuator/**")
            .csrf()
            .disable();

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = adminHttp.authorizeRequests();

        // Register the actuator endpoints
        for (EndpointId endpoint : EndpointId.values()) {
            String path = "/actuator/" + endpoint;

            if (!registry.antMatchers(path).hasRole("ADMIN").exists()) {
                registry
                    .antMatcher(path)
                    .access("#oauth2.clientHasRole('ROLE_ADMIN')");
            }
        }

        adminHttp
            .httpBasic()
            .and().csrf().disable();

        // Configure JWT authentication for other endpoints
        http
            .authorizeRequests()
            .antMatchers(AUTH_WHITELIST).permitAll()
            .anyRequest().authenticated();
    }

    // Dummy EndpointId enum for the sake of completeness
    enum EndpointId {
        INFO, HEALTH;

        @Override
        public String toString() {
            return this.name().toLowerCase();
        }
    }
}