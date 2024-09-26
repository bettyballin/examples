import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.reactive.function.server.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizationContext;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;

public class Temp2451 {

    public static void main(String[] args) {
        // Mock objects for demonstration purposes.
        ServerWebExchange exchange = new MockServerWebExchange();
        ServerRequest serverRequest = ServerRequest.create(exchange, null);

        // Assuming you have a way to get the OAuth2AuthorizedClient
        ServerOAuth2AuthorizedClientRepository authorizedClientRepository = null; // Initialize this properly
        ServerOAuth2AuthorizedClientExchangeFilterFunction oauth2Client = new ServerOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientRepository);

        ServerOAuth2AuthorizationContext authContext = ServerOAuth2AuthorizationContext
                .withAuthorizedClient((OAuth2AuthorizedClient) exchange.getAttributes().get(OAuth2AuthorizedClient.class.getName()))
                .build();

        OAuth2AuthorizedClient authorizedClient = oauth2Client.authorizedClient(authContext).block();

        if (authorizedClient != null) {
            String tokenValue = authorizedClient.getAccessToken().getTokenValue();
            System.out.println("Token Value: " + tokenValue);
        }
    }

    // MockServerWebExchange for demonstration purposes
    private static class MockServerWebExchange extends ServerWebExchangeDecorator {
        protected MockServerWebExchange() {
            super(null);
        }

        @Override
        public ServerWebExchange getDelegate() {
            return null;
        }
    }
}