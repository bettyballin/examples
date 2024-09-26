import java.util.HashMap;
import java.util.Map;

import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;

public class CustomRelyingPartyRegistrationRepository implements RelyingPartyRegistrationRepository {
    private final Map<String, RelyingPartyRegistration> registrations = new HashMap<>();

    @Override
    public RelyingPartyRegistration findByRegistrationId(String registrationId) {
        return registrations.get(registrationId);
    }

    public void save(RelyingPartyRegistration registration) {
        registrations.put(registration.getRegistrationId(), registration);
    }

    public static void main(String[] args) {
        CustomRelyingPartyRegistrationRepository repository = new CustomRelyingPartyRegistrationRepository();
        
        RelyingPartyRegistration.Builder builder = RelyingPartyRegistration.withRegistrationId("example");
        RelyingPartyRegistration registration = builder.assertingPartyDetails(party -> party.entityId("entity-id")).build();

        repository.save(registration);
        
        RelyingPartyRegistration fetchedRegistration = repository.findByRegistrationId("example");
        
        System.out.println(fetchedRegistration != null ? "Registration found" : "Registration not found");
    }
}