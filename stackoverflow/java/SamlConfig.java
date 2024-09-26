import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.InMemoryRelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;

@Configuration
@EnableConfigurationProperties(Saml2RelyingPartyProperties.class)
public class SamlConfig {
    @Bean
    RelyingPartyRegistrationRepository relyingPartyRegistrationRepository(Saml2RelyingPartyProperties properties) {
        // Assuming Saml2RelyingPartyProperties provides necessary information to create RelyingPartyRegistration
        // Replace the following with actual initialization logic using 'properties'
        RelyingPartyRegistration registration = null; // Replace with actual registration
        
        return new InMemoryRelyingPartyRegistrationRepository(registration);
    }
}