import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class Temp1613 {
    public static void main(String[] args) {
        // This is just a placeholder to make the class executable
        System.out.println("Application started");
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public WebFilter loggingFilter() {
        return (ServerWebExchange exchange, WebFilterChain chain) -> 
            ReactiveSecurityContextHolder.getContext()
                .flatMap(context -> {
                    Authentication auth = context.getAuthentication();
                    // apply custom logic based on the authentication

                    // then continue
                    return chain.filter(exchange);
                })
                .switchIfEmpty(chain.filter(exchange));
    }
}