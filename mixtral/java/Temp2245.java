import org.springframework.beans.factory.annotation.Bean;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationContextDefaultAccessor;

import java.util.LinkedHashMap;
import java.util.Map;

public class OAuth2ClientManagerConfig {

    @Bean
    public DefaultOAuth2AuthorizedClientManager authorizedClientManager(
            ClientRegistrationRepository clientRegistrationRepository) {

        var manager = new DefaultOAuth2AuthorizedClientManager(
                clientRegistrationRepository, new OAuth2AuthorizationContextDefaultAccessor());

        // Customize the AuthorizationRequestCustomizer
        manager.setAuthorizedClientQueryParametersConverter(client -> {
            Map<String, String> parameters = new LinkedHashMap<>(
                    manager.getAuthorizedClientQueryParametersConverter()
                            .convert(client));

            // Add your custom scope and audience
            parameters.put("scope", "custom_scope");
            parameters.put("audience", "your-auth0-domain/userinfo");

            return parameters;
        });

        return manager;
    }
}