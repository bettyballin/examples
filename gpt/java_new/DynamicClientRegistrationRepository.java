import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import java.util.concurrent.ConcurrentHashMap;

public class DynamicClientRegistrationRepository implements ClientRegistrationRepository {

    private final ConcurrentHashMap<String, ClientRegistration> registrations;
    private final ClientSecretService clientSecretService;

    public DynamicClientRegistrationRepository(ClientSecretService clientSecretService) {
        this.clientSecretService = clientSecretService;
        this.registrations = new ConcurrentHashMap<>();
    }

    @Override
    public ClientRegistration findByRegistrationId(String registrationId) {
        return registrations.get(registrationId);
    }

    public void addRegistration(String registrationId, ClientRegistration registration) {
        registrations.put(registrationId, registration);
    }
}