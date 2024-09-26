import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrations;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Temp1980 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1980.class, args);
    }

    @Bean
    public AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager(
            ClientRegistrationRepository clientRegistrationRepository,
            OAuth2AuthorizedClientService oauth2AuthorizedClientService) {

        var authorizedClientProvider =
                new CustomAuthorizationGrantTypeTokenResponseClient()
                        .withDefaults();

        return new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistrationRepository, oauth2AuthorizedClientService);
    }

    // Mocking the CustomAuthorizationGrantTypeTokenResponseClient for the sake of this example
    private static class CustomAuthorizationGrantTypeTokenResponseClient {
        public CustomAuthorizationGrantTypeTokenResponseClient withDefaults() {
            // Mock implementation
            return this;
        }
    }
}


Note: You will need to add the necessary dependencies in your `pom.xml` file for Spring Boot and Spring Security OAuth2. Here’s a sample `pom.xml` snippet:

xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-oauth2-client</artifactId>
    </dependency>
</dependencies>