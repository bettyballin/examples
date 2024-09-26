import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

@SpringBootApplication
public class OAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2Application.class, args);
    }

    @Bean
    public ExtendedBaseOAuth2ProtectedResourceDetails extendedBaseOAuth2ProtectedResourceDetails() {
        return new ExtendedBaseOAuth2ProtectedResourceDetails();
    }

    public class ExtendedBaseOAuth2ProtectedResourceDetails extends AuthorizationCodeResourceDetails {

        public boolean isClientOnly() {
            return true;
        }
    }
}