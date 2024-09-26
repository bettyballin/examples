import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.AuthorizeExchangeSpec;
import org.springframework.security.config.web.server.ServerHttpSecurity.ExceptionHandlingSpec;
import org.springframework.security.config.web.server.ServerHttpSecurity.HttpBasicSpec;
import org.springframework.security.config.web.server.ServerHttpSecurity.LogoutSpec;
import org.springframework.security.config.web.server.ServerHttpSecurity.SecurityWebFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Set;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private static final Set<String> UNSECURED =
            Set.of("/health", "/heartbeat");

    @Bean
    SecurityWebFilterChain webFilterChain(final ServerHttpSecurity http) {
        return http
                .authorizeExchange((AuthorizeExchangeSpec exchanges) -> exchanges
                        .matchers(this::blockUnsecured).permitAll()
                        .anyExchange().authenticated()
                )
                .exceptionHandling((ExceptionHandlingSpec exceptionHandling) -> exceptionHandling
                        .authenticationEntryPoint((exchange, exception) -> Mono.error(exception))
                )
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .headers(ServerHttpSecurity.HeaderSpec::disable)
                .logout(ServerHttpSecurity.LogoutSpec::disable)
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
                .build();
    }

    Mono<MatchResult> blockUnsecured(final ServerWebExchange exchange) {
        URI uri = exchange.getRequest().getURI();
        boolean invalid = "http".equalsIgnoreCase(uri.getScheme()) &&
                !UNSECURED.contains(uri.getPath().toLowerCase());
        return invalid ? MatchResult.notMatch() : MatchResult.match();
    }
}