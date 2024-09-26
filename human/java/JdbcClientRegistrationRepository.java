import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.AuthenticationMethod;

@Component
public class JdbcClientRegistrationRepository implements ClientRegistrationRepository {

    private final SsoProviderConfigurationRepository ssoProviderConfigurationRepository;

    @Autowired
    public JdbcClientRegistrationRepository(SsoProviderConfigurationRepository ssoProviderConfigurationRepository) {
        this.ssoProviderConfigurationRepository = ssoProviderConfigurationRepository;
    }

    @Override
    public ClientRegistration findByRegistrationId(String registrationId) {
        Assert.hasText(registrationId, "registrationId cannot be empty");
        SsoProviderConfiguration providerConfiguration = ssoProviderConfigurationRepository.findByRegistrationId(registrationId)
            .orElseThrow(() -> new RuntimeException("ClientRegistration not found by id=" + registrationId));

        String[] scopes = providerConfiguration.getScope().split(",");
        return ClientRegistration.withRegistrationId(providerConfiguration.getRegistrationId())
            .clientId(providerConfiguration.getClientId())
            .clientSecret(providerConfiguration.getClientSecret())
            .clientName(providerConfiguration.getClientName())
            .authorizationGrantType(new AuthorizationGrantType(providerConfiguration.getAuthorizationGrantType()))
            .authorizationUri(providerConfiguration.getAuthorizationUri())
            .clientAuthenticationMethod(new ClientAuthenticationMethod(providerConfiguration.getClientAuthenticationMethod()))
            .scope(scopes)
            .tokenUri(providerConfiguration.getTokenUri())
            .userInfoAuthenticationMethod(new AuthenticationMethod(providerConfiguration.getAuthenticationMethod()))
            .userInfoUri(providerConfiguration.getUserInfoUri())
            .userNameAttributeName(providerConfiguration.getUserNameAttributeName())
            .redirectUri(providerConfiguration.getRedirectUri())
            .build();
    }
}

interface SsoProviderConfigurationRepository {
    java.util.Optional<SsoProviderConfiguration> findByRegistrationId(String registrationId);
}

class SsoProviderConfiguration {
    private String registrationId;
    private String clientId;
    private String clientSecret;
    private String clientName;
    private String authorizationGrantType;
    private String authorizationUri;
    private String clientAuthenticationMethod;
    private String scope;
    private String tokenUri;
    private String authenticationMethod;
    private String userInfoUri;
    private String userNameAttributeName;
    private String redirectUri;

    // Getters and setters for all fields

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAuthorizationGrantType() {
        return authorizationGrantType;
    }

    public void setAuthorizationGrantType(String authorizationGrantType) {
        this.authorizationGrantType = authorizationGrantType;
    }

    public String getAuthorizationUri() {
        return authorizationUri;
    }

    public void setAuthorizationUri(String authorizationUri) {
        this.authorizationUri = authorizationUri;
    }

    public String getClientAuthenticationMethod() {
        return clientAuthenticationMethod;
    }

    public void setClientAuthenticationMethod(String clientAuthenticationMethod) {
        this.clientAuthenticationMethod = clientAuthenticationMethod;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getTokenUri() {
        return tokenUri;
    }

    public void setTokenUri(String tokenUri) {
        this.tokenUri = tokenUri;
    }

    public String getAuthenticationMethod() {
        return authenticationMethod;
    }

    public void setAuthenticationMethod(String authenticationMethod) {
        this.authenticationMethod = authenticationMethod;
    }

    public String getUserInfoUri() {
        return userInfoUri;
    }

    public void setUserInfoUri(String userInfoUri) {
        this.userInfoUri = userInfoUri;
    }

    public String getUserNameAttributeName() {
        return userNameAttributeName;
    }

    public void setUserNameAttributeName(String userNameAttributeName) {
        this.userNameAttributeName = userNameAttributeName;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirect