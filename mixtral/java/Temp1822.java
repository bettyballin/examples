import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebTestClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebTestClientApplication.class, args);
    }

    @Bean
    public WebTestClient webTestClient(WebApplicationContext wac) {
        return WebTestClient.bindToApplicationContext(wac).webFilter(new TestAuthenticationFilter()).build();
    }

    class TestAuthenticationFilter implements ExchangeFilterFunction {

        @Override
        public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
            // Set authentication here
            return next.exchange(request);
        }

    }
}