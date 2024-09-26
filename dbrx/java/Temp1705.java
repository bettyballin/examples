import org.springframework.http.HttpHeaders;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class Temp1705 {

    public static void main(String[] args) {
        Temp1705 temp = new Temp1705();
        temp.securityWebFilterChain(ServerHttpSecurity.http());
    }

    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.authorizeExchange(exchanges -> exchanges
                .pathMatchers("/api/rest/**")
                .access((authentication, context) -> Mono.justOrEmpty(authentication)
                        .filter(a -> a != null && a.getCredentials() != null && !a.getCredentials().toString().isEmpty())
                        .switchIfEmpty(Mono.error(new AccessDeniedException("Authorization header is empty")))
                        .flatMap(a -> {
                            ServerWebExchange exchange = context.getExchange();
                            if (exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                                return Mono.just(true);
                            } else {
                                return Mono.just(false);
                            }
                        }))
                .anyExchange().permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedHandler((exchange, exception) -> Mono.empty()))
                .build();
    }
}