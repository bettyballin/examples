import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@SpringBootApplication
public class Temp2274 implements CommandLineRunner {

    @Autowired
    private InMemoryClientRegistrationRepository clientRegistrations;

    public static void main(String[] args) {
        SpringApplication.run(Temp2274.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        setNewSecret("newSecretValue");
    }

    public void setNewSecret(String newSecret) {
        ClientRegistration registration = this.clientRegistrations
            .findByRegistrationId("sbbol")
            // Update the secret
            .mutate()
                .clientSecret(newSecret)
                .build();

        clientRegistrations.remove("sbbol");

        // Add it back with updated values
        this.clientRegistrations.addClientRegistration(registration);
    }
}