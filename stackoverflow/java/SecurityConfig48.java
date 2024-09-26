import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PUT;

@EnableResourceServer
public class SecurityConfig48 {

    @Bean
    public ResourceServerConfigurerAdapter resourceServerConfigurer(final ScopesProperties oauthProperties) {
        return new ResourceServerConfigurerAdapter() {
            @Override
            public void configure(final HttpSecurity http) throws Exception {
                http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
                        .authorizeRequests()
                        .mvcMatchers(GET, "/foo")
                        .access(oauthProperties.getFooRead())
                        .mvcMatchers(GET, "/bar")
                        .access(oauthProperties.getBarRead())
                        .mvcMatchers(PUT, "/bar")
                        .access(oauthProperties.getBarWrite())
                        .anyRequest().denyAll();
            }
        };
    }

    // Placeholder for the ScopesProperties class
    // This class should provide getters for the oauthProperties
    public class ScopesProperties {
        public String getFooRead() {
            // Implementation here
            return null;
        }

        public String getBarRead() {
            // Implementation here
            return null;
        }

        public String getBarWrite() {
            // Implementation here
            return null;
        }
    }
}