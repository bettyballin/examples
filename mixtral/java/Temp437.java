import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.saml.SAMLEntryPoint;
import org.springframework.security.saml.SAMLCredentialExpirationPolicy;
import org.springframework.security.saml.SAMLDefaultCredentialExpirationPolicy;

@Configuration
public class Temp437 {
    public static void main(String[] args) {
        // You can test your configuration here
    }

    @Bean
    public SAMLEntryPoint samlEntryPoint() {
        return new SAMLEntryPoint();
    }

    @Bean
    public SAMLCredentialExpirationPolicy expirationPolicy() {
        final int validityPeriod = 600;
        return new SAMLDefaultCredentialExpirationPolicy(validityPeriod);
    }
}