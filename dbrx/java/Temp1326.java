import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebClientApplication.class, args);
    }

    @Configuration
    public static class WebClientConfig {

        @Bean
        public WebClient webClient(ReactiveOAuth2AuthorizedClientManager authorizedClientManager) {
            ServerOAuth2AuthorizedClientExchangeFilterFunction oauth2 =
                    new ServerOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
            return WebClient.builder()
                    .filter(oauth2)
                    .build();
        }

        @Bean
        public ReactiveOAuth2AuthorizedClientManager authorizedClientManager(
                @Autowired ReactiveClientRegistrationRepository clientRegistrationRepository,
                @Value("${spring.security.oauth2.client.registration.client-registration-id.token-uri}") String tokenUri) {
            ReactiveOAuth2AuthorizedClientManager authorizedClientManager = new ReactiveOAuth2AuthorizedClientManager(
                    clientRegistrationRepository, new ServerOAuth2AuthorizedClientExchangeFilterFunction());
            authorizedClientManager.setAuthorizedClientProvider(new org.springframework.security.oauth2.client.web.reactive.function.client.DefaultReactiveOAuth2AuthorizedClientProvider());
            return authorizedClientManager;
        }
    }

    // Example usage within a service or component
    @Bean
    public CommandLineRunner run(WebClient webClient) {
        return args -> {
            Mono<String> body = webClient
                    .get()
                    .uri("https://example.com/api")
                    .attributes(ServerOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId("client-registration-id"))
                    .retrieve()
                    .bodyToMono(String.class);

            body.subscribe(System.out::println);
        };
    }
}