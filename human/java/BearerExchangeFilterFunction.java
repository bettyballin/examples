import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.oauth2.core.AbstractOAuth2Token;
import org.springframework.util.Assert;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class BearerExchangeFilterFunction implements ExchangeFilterFunction {

    @Override
    public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
        return ReactiveSecurityContextHolder.getContext()
                .map(c -> (c.getAuthentication().getCredentials()))
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

    public static void main(String[] args) {
        ClientHttpConnector connector = new ReactorClientHttpConnector();
        WebClient client = WebClient.builder()
                .clientConnector(connector)
                .filter(new BearerExchangeFilterFunction())
                .build();

        // Example usage
        client.get()
                .uri("http://example.com")
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(System.out::println);

        // To keep the application running for testing purposes
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}