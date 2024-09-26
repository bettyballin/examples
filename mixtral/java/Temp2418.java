import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class Temp2418 {
    public static void main(String[] args) {
        // This is just a placeholder main method.
        // The actual execution relies on the Spring Framework to run the web server.
    }

    @Bean
    public WebFilter loggingFilter() {
        return (ServerWebExchange exchange, WebFilterChain chain) ->
            ReactiveSecurityContextHolder.getContext().flatMap(context ->
                Mono.justOrEmpty(context.getAuthentication())
                    .doOnNext(auth -> {
                        // apply some custom logic based on the authentication
                    })
                    // then continue
                    .then(chain.filter(exchange))
            );
    }
}