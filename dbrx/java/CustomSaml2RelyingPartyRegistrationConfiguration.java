import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configurers.saml2.Saml2LoginConfigurer;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.InMemoryRelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;

@Configuration
@ConditionalOnClass({ Saml2LoginConfigurer.class, RelyingPartyRegistrationRepository.class })
public class CustomSaml2RelyingPartyRegistrationConfiguration {

    @Bean
    public RelyingPartyRegistrationRepository relyingPartyRegistrationRepository() {
        RelyingPartyRegistration.Builder relyingPartyRegistrationBuilder = RelyingPartyRegistration
                .withRegistrationId("example-id");

        relyingPartyRegistrationBuilder.assertingPartyDetails(party -> party
                .entityId("example-entity-id")
                .singleSignOnServiceLocation("https://example.com/sso")
                .wantAuthnRequestsSigned(false)
                .verificationX509Credentials(c -> c.add("-----BEGIN CERTIFICATE-----\n...\n-----END CERTIFICATE-----")));

        RelyingPartyRegistration relyingPartyRegistration = relyingPartyRegistrationBuilder.build();

        return new InMemoryRelyingPartyRegistrationRepository(relyingPartyRegistration);
    }

}