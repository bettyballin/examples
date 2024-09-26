import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Controller
public class IndexController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/")
    public Mono<String> index() {
        String resourceUri = "https://example.com/resource";

        WebClient webClient = webClientBuilder
                .filter(new ServerOAuth2AuthorizedClientExchangeFilterFunction())
                .build();

        return webClient
                .get()
                .uri(resourceUri)
                .attributes(ServerOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId("okta"))
                .retrieve()
                .bodyToMono(String.class)
                .thenReturn("index");
    }
}