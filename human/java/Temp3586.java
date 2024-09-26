import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.ServerWebExchange;
import org.springframework.security.web.server.ServerWebExchangeMatcher;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import org.springframework.security.web.server.authorization.AuthorizationWebFilter;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;

@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
            .authorizeExchange()
                .matcher(new MySubdomainMatcher()).permitAll()
                .pathMatchers("/**").authenticated();
        return http.build();
    }

}

@Component
class MySubdomainMatcher implements ServerWebExchangeMatcher {

    @Override
    public Mono<MatchResult> matches(ServerWebExchange exchange) {
        // perform the logic in the request
        // For example, to match all requests:
        return MatchResult.match();
    }

}