import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

public class JwtExchangeFilterFunction implements ExchangeFilterFunction {

    @Override
    public Mono<ClientResponse> filter(ClientRequest clientRequest, ExchangeFunction exchange) {
        return Mono.subscriberContext()
                .flatMap(context -> {
                    Authentication authentication = context.get(Authentication.class);
                    if (authentication instanceof BearerTokenAuthenticationToken) {
                        String tokenValue = ((BearerTokenAuthenticationToken) authentication).getToken().getTokenValue();
                        ClientRequest newClientRequest = ClientRequest.from(clientRequest)
                                .headers(headers -> headers.set("Authorization", "Bearer " + tokenValue))
                                .build();

                        return exchange.exchange(newClientRequest);
                    }
                    return Mono.error(() -> new IllegalStateException("No JWT found in SecurityContext"));
                });
    }

}