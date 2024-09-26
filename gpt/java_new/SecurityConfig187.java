import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig187 {

    private static final String[] HTTP_WHITELIST = {
        "/health", // Add any other paths you want to whitelist here
    };

    @Bean
    public SecurityWebFilterChain webFilterChain(ServerHttpSecurity http) {
        return http
            .authorizeExchange(exchanges -> exchanges
                .pathMatchers(HTTP_WHITELIST).permitAll()
                .anyExchange().authenticated()
            )
            .csrf().disable()
            .headers().frameOptions().disable()
            .and().build();
    }
}