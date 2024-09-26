import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@ConditionalOnClass(EnableOAuth2Client.class)
public class OAuth2RestOperationsConfiguration {

    @Configuration
    @ConditionalOnNotWebApplication
    protected static class SingletonScopedConfiguration {

        @Bean
        @ConfigurationProperties("security.oauth2.client")
        @Primary
        public ClientCredentialsResourceDetails oauth2RemoteResource() {
            ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
            return details;
        }
    }
}