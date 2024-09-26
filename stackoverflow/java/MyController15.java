import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class MyController15 {
  private final WebClient webClient;

  public MyController15(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.build();
  }

  @GetMapping("/")
  public Mono<String> index() {
    String resourceUri = "http://example.com"; // replace with actual URI

    return webClient
      .get()
      .uri(resourceUri)
      .retrieve()
      .bodyToMono(String.class)
      .then(Mono.just("index"));
  }
}