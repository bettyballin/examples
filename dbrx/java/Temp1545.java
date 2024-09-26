import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration.Builder;

public class Temp1545 {
    public static void main(String[] args) {
        String registrationId = "exampleRegistrationId"; // Replace with actual registration ID
        RelyingPartyRegistration relyingPartyRegistration = RelyingPartyRegistration.withRegistrationId(registrationId)
            .assertionConsumerServiceUrlTemplate("{baseUrl}/login/saml2/{registrationId}")
            .remoteId(registrationId) // Add this line to avoid a NPE
            .build();

        // Output the built RelyingPartyRegistration object for demonstration purposes
        System.out.println(relyingPartyRegistration);
    }
}