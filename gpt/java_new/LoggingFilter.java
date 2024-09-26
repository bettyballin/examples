import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Component;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LoggingFilter {

    @Bean
    public WebFilter loggingFilter() {
        return (exchange, chain) -> ReactiveSecurityContextHolder.getContext()
            .map(SecurityContext::getAuthentication)
            .defaultIfEmpty(null) // If no authentication is present, continue without it
            .flatMap(authentication -> {
                // Apply some custom logic based on the authentication object
                if (authentication != null) {
                    // Your custom logic with the authentication object
                }

                // Then continue the filter chain
                return chain.filter(exchange);
            })
            .contextWrite(ReactiveSecurityContextHolder.withSecurityContext(Mono.deferContextual(Mono::just)));
    }
}