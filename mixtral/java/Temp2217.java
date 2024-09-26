import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;

@SpringBootApplication
public class Temp2217 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2217.class, args);
    }
}

@Configuration
class AppConfig {
    @Bean
    public RelyingPartyRegistrationRepository relyingPartyRegistrationRepo(CustomRelyingPartyRegistrationRepository repo) {
        return repo;
    }
}

// Dummy class to make the code compile
class CustomRelyingPartyRegistrationRepository implements RelyingPartyRegistrationRepository {
    // Implement the required methods here
}