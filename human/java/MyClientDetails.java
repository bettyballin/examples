import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

public class MyClientDetails extends BaseClientDetails implements ClientDetails {

    private static final long serialVersionUID = 1L;

    private String clientId;
    private Set<String> resourceIds;
    private boolean secretRequired;
    private String clientSecret;
    private boolean scoped;
    private Set<String> scope;
    private Set<String> authorizedGrantTypes;
    private Set<String> registeredRedirectUri;
    private Collection<GrantedAuthority> authorities;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;
    private Map<String, Object> additionalInformation;

    // Constructor with required parameters
    public MyClientDetails(String clientId, Set<String> resourceIds, boolean secretRequired, 
                           String clientSecret, boolean scoped, Set<String> scope, 
                           Set<String> authorizedGrantTypes, Set<String> registeredRedirectUri, 
                           Collection<GrantedAuthority> authorities, Integer accessTokenValiditySeconds, 
                           Integer refreshTokenValiditySeconds, Map<String, Object> additionalInformation) {
        this.clientId = clientId;
        this.resourceIds = resourceIds;
        this.secretRequired = secretRequired;
        this.clientSecret = clientSecret;
        this.scoped = scoped;
        this.scope = scope;
        this.authorizedGrantTypes = authorizedGrantTypes;
        this.registeredRedirectUri = registeredRedirectUri;
        this.authorities = authorities;
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
        this.additionalInformation = additionalInformation;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return resourceIds != null ? Collections.unmodifiableSet(resourceIds) : Collections.emptySet();
    }

    @Override
    public boolean isSecretRequired() {
        return secretRequired;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public boolean isScoped() {
        return scoped;
    }

    @Override
    public Set<String> getScope() {
        return scope != null ? Collections.unmodifiableSet(scope) : Collections.emptySet();
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes != null ? Collections.unmodifiableSet(authorizedGrantTypes) : Collections.emptySet();
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return registeredRedirectUri != null ? Collections.unmodifiableSet(registeredRedirectUri) : Collections.emptySet();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return additionalInformation != null ? Collections.unmodifiableMap(additionalInformation) : Collections.emptyMap();
    }
}