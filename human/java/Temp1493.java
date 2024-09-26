import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.saml.metadata.ExtendedMetadataDelegate;
import org.springframework.security.saml.metadata.MetadataProviderException;
import org.springframework.security.saml.metadata.provider.HTTPMetadataProvider;

@Configuration
public class Temp1493 {

    public static void main(String[] args) {
        // Main method can be used to launch the Spring context if needed.
    }

    @Bean
    @Qualifier("idp-ssocircle")
    public ExtendedMetadataDelegate ssoCircleExtendedMetadataProvider() throws MetadataProviderException {
        @SuppressWarnings("deprecation")
        HTTPMetadataProvider httpMetadataProvider = new HTTPMetadataProvider("https://idp.ssocircle.com/idp-meta.xml", 5000);
        return new ExtendedMetadataDelegate(httpMetadataProvider, null);
        // other config.s...
    }
}