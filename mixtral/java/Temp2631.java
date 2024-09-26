import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;

@SpringBootApplication
public class Temp2631Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp2631Application.class, args);
    }

    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // Allow access to /users endpoint without authentication
            http.authorizeRequests().antMatchers("/users").permitAll();

            // Require a valid JWT token for the GET /users/{userId}/permissions
            http.authorizeRequests()
                .antMatchers("/users/**")
                .authenticated()
                .and().oauth2ResourceServer().jwt();

            // Disable CSRF protection
            http.csrf().disable();

            http.exceptionHandling()
                .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint());
        }

        @Bean
        public JwtAuthenticationConverter jwtAuthenticationConverter() {
            JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
            grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
            grantedAuthoritiesConverter.setAuthoritiesClaimName("roles");

            JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
            jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
            return jwtAuthenticationConverter;
        }
    }
}