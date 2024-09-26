import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;

public class Temp2453 {

    private static WebClient webClient = WebClient.create();
    private static String resourceBaseUri = "http://example.com/resource";

    public static void main(String[] args) {

        getTokenValue()
            .flatMap(token -> {
                try {
                    return webClient.get()
                        .uri(new URI(resourceBaseUri))
                        .retrieve()
                        .bodyToMono(String.class);
                } catch (URISyntaxException e) {
                    return Mono.error(e);
                }
            })
            .subscribe(response -> {
                System.out.println("Response: " + response);
            }, error -> {
                System.err.println("Error: " + error.getMessage());
            });
    }

    private static Mono<String> getTokenValue() {
        // Simulate fetching a token value
        return Mono.just("dummyToken");
    }
}