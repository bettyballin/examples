import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserService8 {

    private final WebClient webClient;

    public UserService8(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://your-auth-server.com").build();
    }

    public Mono<List<User>> getAllUsers(String accessToken) {
        return webClient.get()
                .uri("/users")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<User>>() {});
    }
}