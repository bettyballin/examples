import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import reactor.core.publisher.Mono;
import org.springframework.web.server.ServerWebExchange;

public class AuthenticationUpdater {

    public Mono<ServerWebExchange> updateAuthentication(ServerWebExchange exchange) {
        Mono<Authentication> updatedUser = exchange
                .getPrincipal()
                .cast(UsernamePasswordAuthenticationToken.class)
                .map(auth -> new UsernamePasswordAuthenticationToken(
                        "updatedFirstName", 
                        auth.getCredentials(), 
                        auth.getAuthorities()
                ));

        return updatedUser.map(auth -> exchange.mutate().principal(Mono.just(auth)).build());
    }
    
    public static void main(String[] args) {
        // This is just a placeholder for the main method. Actual usage would be within a Spring WebFlux environment.
    }
}