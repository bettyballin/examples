import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

public class CustomAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {
    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException ex) {
        if (ex instanceof MyCustomExceptionThrownFromFindByUsername) {
            // Handle your custom exception here
            return exchange.getResponse().setComplete();
        } else {
            // For other authentication exceptions
            return Mono.defer(() -> {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            });
        }
    }
}

class MyCustomExceptionThrownFromFindByUsername extends AuthenticationException {
    public MyCustomExceptionThrownFromFindByUsername(String msg) {
        super(msg);
    }
}