import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class SubdomainSecurityWebFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String host = exchange.getRequest().getHeaders().getFirst("Host");
        
        if (host != null) {
            String subdomain = extractSubdomain(host);
            
            if ("test".equals(subdomain)) {
                return chain.filter(exchange);
            }
        }
        
        return exchange.getResponse().setComplete();
    }

    private String extractSubdomain(String host) {
        if (host == null || !host.contains(".")) {
            return null;
        }
        return host.split("\\.")[0];
    }
}