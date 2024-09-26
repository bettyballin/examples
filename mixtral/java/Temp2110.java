import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint;
import org.springframework.security.web.server.AuthenticationEntryPoint;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class Temp2110 {
    public static void main(String[] args) {
        // Main method can be used to run any setup if required
    }

    @Bean
    public AuthenticationEntryPoint jwtAuthenticationEntryPoint() {
        return (ServerWebExchange exchange, Exception e) ->
            Mono.fromRunnable(() ->
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED)
            );
    }
}