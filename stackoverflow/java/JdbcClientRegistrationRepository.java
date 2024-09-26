import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.util.Assert;

@Component
@RequiredArgsConstructor
public class JdbcClientRegistrationRepository implements ClientRegistrationRepository {

    private final SsoProviderConfigurationRepository ssoProviderConfigurationRepository;

    @Override
    public ClientRegistration findByRegistrationId(String registrationId) {
        Assert.hasText(registrationId, "registrationId cannot be empty");
        SsoProviderConfiguration providerConfiguration = ssoProviderConfigurationRepository.findByRegistrationId(registrationId)
            .orElseThrow(() -> new RuntimeException("ClientRegistration not found by id=" + registrationId));

        String[] scopes = providerConfiguration.getScope().split(",");

        return ClientRegistration.withRegistrationId(registrationId)
            .clientId(providerConfiguration.getClientId())
            .clientSecret(providerConfiguration.getClientSecret())
            .clientName(providerConfiguration.getClientName())
            .authorizationGrantType(new AuthorizationGrantType(providerConfiguration.getAuthorizationGrantType()))
            .redirectUriTemplate(providerConfiguration.getRedirectUri())
            .scope(scopes)
            .authorizationUri(providerConfiguration.getAuthorizationUri())
            .tokenUri(providerConfiguration.getTokenUri())
            .userInfoUri(providerConfiguration.getUserInfoUri())
            .userNameAttributeName(providerConfiguration.getUserNameAttributeName())
            .clientAuthenticationMethod(new ClientAuthenticationMethod(providerConfiguration.getClientAuthenticationMethod()))
            .build();
    }
}