import org.springframework.lang.NonNull;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.oauth2.core.AbstractOAuth2Token;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

public class BearerExchangeFilterFunction implements ExchangeFilterFunction {

    @Override
    @NonNull
    public Mono<ClientResponse> filter(@NonNull ClientRequest request, @NonNull ExchangeFunction next) {
        return ReactiveSecurityContextHolder.getContext()
                .map(context -> context.getAuthentication().getCredentials())
                .cast(AbstractOAuth2Token.class)
                .checkpoint()
                .map(token -> bearer(request, token))
                .defaultIfEmpty(request)
                .flatMap(next::exchange);
    }

    private ClientRequest bearer(ClientRequest request, AbstractOAuth2Token token) {
        return ClientRequest.from(request)
                .headers(headers -> headers.setBearerAuth(token.getTokenValue()))
                .build();
    }
}