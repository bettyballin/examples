import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

import java.util.Collections;
import java.util.Map;

@Configuration
public class MyConfig {

    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager(
            ClientRegistrationRepository clientRegistrationRepository,
            OAuth2AuthorizedClientService oAuth2AuthorizedClientService) throws Exception {

        DefaultOAuth2UserService userDetailsService = new DefaultOAuth2UserService();

        ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId("my-client");
        if (clientRegistration == null) {
            throw new IllegalArgumentException("Client registration not found for my-client");
        }

        return new AuthorizedClientServiceOAuth2AuthorizedClientManager(oAuth2AuthorizedClientService, clientRegistrationRepository) {
            @Override
            protected Map<String, Object> obtainAdditionalParameters(ClientRegistration.Builder builder) {
                return Collections.singletonMap("prompt", "consent");
            }
        };
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        // You should define and return your actual ClientRegistration repository here
        // This is just a placeholder for the example
        ClientRegistration clientRegistration = ClientRegistration.withRegistrationId("my-client")
                .clientId("client-id")
                .clientSecret("client-secret")
                .authorizationGrantType(org.springframework.security.oauth2.core.AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .authorizationUri("https://example.com/oauth/authorize")
                .tokenUri("https://example.com/oauth/token")
                .jwkSetUri("https://example.com/oauth/jwks")
                .userInfoUri("https://example.com/userinfo")
                .build();
        return new InMemoryClientRegistrationRepository(clientRegistration);
    }

    @Bean
    public OAuth2AuthorizedClientService oAuth2AuthorizedClientService(ClientRegistrationRepository clientRegistrationRepository) {
        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository);
    }
}