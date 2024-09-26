import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;

@SpringBootApplication
public class Temp1388 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1388.class, args);

        WebClient webClient = loadBalancedWebClientBuilder().build();
        webClient.get().uri("http://my-service/api").retrieve()
                .bodyToMono(String.class)
                .subscribe(response -> {
                    System.out.println("Response: " + response);
                });
    }

    @Bean
    @LoadBalanced
    public static WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder()
                .filter(jwtExchangeFilterFunction());
    }

    @Bean
    public static ExchangeFilterFunction jwtExchangeFilterFunction() {
        return (clientRequest, next) -> {
            // Add your JWT handling logic here
            return next.exchange(clientRequest);
        };
    }
}