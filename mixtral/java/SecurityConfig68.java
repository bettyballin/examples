import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.ServerHttpSecurity;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain webFilterChain(ServerHttpSecurity http) throws Exception {
        return http
            .authorizeExchange()
                // permit all requests to /health
                .pathMatchers("/health").permitAll()
                // enforce HTTPS for other paths
                .anyExchange().requiresSecure()
            .and()
            .build();
    }
}