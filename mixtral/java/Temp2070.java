import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers;
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.OAuth2LoginMutator;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootApplication
public class Temp2070 {

    @Autowired
    private ApplicationContext context;

    private WebTestClient webTestClient;

    public static void main(String[] args) {
        SpringApplication.run(Temp2070.class, args);
    }

    @Autowired
    public void setWebTestClient() {
        webTestClient = WebTestClient.bindToApplicationContext(context)
                .configureClient()
                .filter((exchange, chain) -> {
                    OAuth2LoginMutator oauth2LoginMutator = SecurityMockServerConfigurers.mockOAuth2Login().oidcUser(() -> new CustomOidcUser());
                    return chain.filter(exchange.mutate().principal(oauth2LoginMutator.principal()).build());
                })
                .baseUrl("http://localhost:" + port)
                .build();
    }

    // Define CustomOidcUser class or import it if it's defined elsewhere
    public static class CustomOidcUser {
        // Implementation details
    }

    // Add port variable (e.g., @LocalServerPort if using Spring Boot Test)
    private int port = 8080;  // Example port, adjust as necessary
}