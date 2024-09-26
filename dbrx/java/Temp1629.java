import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.AbstractOAuth2Token;
import org.springframework.security.oauth2.server.resource.web.server.ServerBearerTokenAuthenticationConverter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

public class Temp1629 {

    @Autowired
    private ReactiveOAuth2AuthorizedClientManager authorizedClientManager;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Temp1629 temp = context.getBean(Temp1629.class);
        temp.execute();
    }

    public void execute() {
        // Simulate a ServerWebExchange (normally you get this from a web request)
        ServerWebExchange exchange = ServerWebExchange.from(org.springframework.mock.http.server.reactive.MockServerHttpRequest.get("/").build());

        Mono<OAuth2AuthorizedClient> authorizedClient = this.authorizedClientManager.authorize(
            new org.springframework.security.oauth2.client.AuthorizeRequest("new-be-App", OAuth2AuthenticationToken.class.cast(null)));

        Mono<String> tokenValue = authorizedClient
                .map(OAuth2AuthorizedClient::getAccessToken)
                .map(AbstractOAuth2Token::getTokenValue);

        // Print the token value for demonstration purposes
        tokenValue.subscribe(System.out::println);
    }

    @Configuration
    static class Config {
        @Bean
        public ReactiveOAuth2AuthorizedClientManager authorizedClientManager() {
            return new ReactiveOAuth2AuthorizedClientManager(
                new ReactiveClientRegistrationRepository() {
                    @Override
                    public Mono<org.springframework.security.oauth2.client.registration.ClientRegistration> findByRegistrationId(String registrationId) {
                        return Mono.empty();
                    }
                });
        }

        @Bean
        public Temp1629 temp1629(ReactiveOAuth2AuthorizedClientManager authorizedClientManager) {
            Temp1629 temp = new Temp1629();
            temp.authorizedClientManager = authorizedClientManager;
            return temp;
        }
    }
}