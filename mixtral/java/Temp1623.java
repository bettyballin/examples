import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistration.Builder;
import org.springframework.security.oauth2.client.registration.CommonOAuth2Provider;

@SpringBootApplication
public class Temp1623 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1623.class, args);
    }

    @Bean
    public ClientRegistrationRepository clientRegistrations() {
        return new InMemoryClientRegistrationRepository(this.googleClientRegistration());
    }

    private ClientRegistration googleClientRegistration() {
        return CommonOAuth2Provider
                .GOOGLE
                .getBuilder("client-id")
                .clientId("your-client-id")
                .clientSecret("your-client-secret")
                .redirectUriTemplate("{baseUrl}/{action}/oauth2/code/{registrationId}")
                .build();
    }
}