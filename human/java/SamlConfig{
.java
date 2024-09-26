import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.saml2.provider.service.registration.InMemoryRelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;

@Configuration
@EnableConfigurationProperties(Saml2RelyingPartyProperties.class)
public class SamlConfig {

    @Bean
    RelyingPartyRegistrationRepository relyingPartyRegistrationRepository(Saml2RelyingPartyProperties properties) {
        // Example implementation with one relying party registration from properties
        Saml2RelyingPartyProperties.Registration registration = properties.getRelyingparty().getRegistrations().values().stream().findFirst().orElseThrow();
        
        RelyingPartyRegistration relyingPartyRegistration = RelyingPartyRegistration.withRegistrationId(registration.getEntityId())
                .assertionConsumerServiceLocation(registration.getAcs().getLocation())
                .assertingPartyDetails(party -> party.entityId(registration.getEntityId())
                        .singleSignOnServiceLocation(registration.getSso().getLocation()))
                .build();
        
        return new InMemoryRelyingPartyRegistrationRepository(relyingPartyRegistration);
    }
}