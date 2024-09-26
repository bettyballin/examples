import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class YourController9 {

    private final WebClient webClient;

    public YourController9(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/")
    public Mono<String> index(@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient authorizedClient) {
        String resourceUri = "your-resource-uri"; // Replace with actual URI
        
        return webClient
                .get()
                .uri(resourceUri)
                .attributes(ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient(authorizedClient))
                .retrieve()
                .bodyToMono(String.class)
                .thenReturn("index");
    }
}