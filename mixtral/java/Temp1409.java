import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;

@Configuration
public class Temp1409 {
    public static void main(String[] args) {
        // Main method can be used to launch application or for testing purpose
    }

    @Bean(name = "sparklrClientContext")
    public OAuth2ClientContext sparklrClientContext() {
        return new DefaultOAuth2ClientContext();
    }

    @Bean(name = "facebookClientContext")
    public OAuth2ClientContext facebookClientContext() {
        return new DefaultOAuth2ClientContext();
    }
}