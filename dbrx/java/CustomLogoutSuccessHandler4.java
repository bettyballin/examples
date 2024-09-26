import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CustomLogoutSuccessHandler implements ServerLogoutSuccessHandler {

    @Override
    public Mono<Void> onLogoutSuccess(WebFilterExchange exchange, Authentication authentication) {
        // Perform any necessary cleanup here

        return exchange.getExchange().getResponse().writeWith(Mono.just(exchange.getExchange().getResponse().bufferFactory().wrap(new byte[0])))
                .doOnNext(data -> exchange.getExchange().getResponse().setStatusCode(HttpStatus.OK));
    }
}