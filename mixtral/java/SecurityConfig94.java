import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.authentication.ReactiveAuthenticationManager;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Autowired
    private ReactiveAuthenticationManager authenticationManager;

    // Shared configuration method
    public ServerHttpSecurity configureSharedSettings(ServerHttpSecurity http) {
        return http
                .authenticationManager(this.authenticationManager);

        /*
         * Add other common configurations here such as:
         * - CSRF
         * - Form Login
         */
    }

    // Service A specific configuration
    @Bean
    public SecurityWebFilterChain securityWebFilterChainForServiceA(ServerHttpSecurity http) {
        return configureSharedSettings(http.securityMatcher("/api/serviceA/**"))
                .authorizeExchange()
                    .pathMatchers(HttpMethod.GET, "/api/serviceA/**")
                    .hasAuthority("PROP_A")
                .and()
                .build();

        /*
         * Add other service A specific configurations here
         */

        // Build and return the SecurityWebFilterChain
    }

    // Service B specific configuration
    @Bean
    public SecurityWebFilterChain securityWebFilterChainForServiceB(ServerHttpSecurity http) {
        return configureSharedSettings(http.securityMatcher("/api/serviceB/**"))
                .authorizeExchange()
                    .pathMatchers(HttpMethod.GET, "/api/serviceB/**")
                    .hasAuthority("PROP_B")
                .and()
                .build();

        /*
         * Add other service B specific configurations here
         */

        // Build and return the SecurityWebFilterChain
    }
}