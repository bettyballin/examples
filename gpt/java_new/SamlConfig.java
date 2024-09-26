import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.InMemoryRelyingPartyRegistrationRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Configuration
public class SamlConfig {

    @Autowired
    private YourDatabaseRepository yourDatabaseRepository;

    @Bean
    public RelyingPartyRegistrationRepository relyingPartyRegistrationRepository() {
        Collection<RelyingPartyRegistration> registrations = yourDatabaseRepository.findAll().stream()
                .map(this::convertToRelyingPartyRegistration)
                .collect(Collectors.toList());
        return new InMemoryRelyingPartyRegistrationRepository(registrations);
    }

    private RelyingPartyRegistration convertToRelyingPartyRegistration(YourSamlConfigurationEntity entity) {
        // Conversion logic here
        return null; // Replace with actual conversion code
    }
}