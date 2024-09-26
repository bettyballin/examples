import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

public class OAuthConfiguration {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(myClientRegistration());
    }

    private ClientRegistration myClientRegistration() {
        return ClientRegistration.withRegistrationId("my-client")
                // ... other necessary configuration
                .tokenUri("https://oauth2.provider.com/token")
                .clientId("client-id")
                .clientSecret("client-secret")
                .build();
    }
}