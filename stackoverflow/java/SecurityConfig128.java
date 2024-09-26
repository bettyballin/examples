import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.net.URI;
import java.util.Set;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig128 {

    private static final Set<String> UNSECURED = 
                 Set.of("/health", "/heartbeat");

    @Bean
    SecurityWebFilterChain webFilterChain(final ServerHttpSecurity http) {
        return http
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers(UNSECURED.toArray(new String[0])).permitAll()
                        .anyExchange().authenticated()
                )
                .csrf().disable()
                .headers().disable()
                .logout().disable()
                .httpBasic().disable()
                .build();
    }
}