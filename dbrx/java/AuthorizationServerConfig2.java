Here is the corrected code:


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import java.util.Collection;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private JwtTokenStore jwtTokenStore;

    @Autowired
    private JdbcTokenStore jdbcTokenStore;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        CompositeTokenStore compositeTokenStore = new CompositeTokenStore();
        compositeTokenStore.addDelegate("password", jwtTokenStore);
        compositeTokenStore.addDelegate("refresh_token", jdbcTokenStore);

        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(compositeTokenStore);
        endpoints.tokenServices(tokenServices)
                 .authenticationManager(authenticationManager);
    }

    // other configurations
}

// CompositeTokenStore class implementation
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CompositeTokenStore implements TokenStore {

    private final Map<String, TokenStore> delegates = new HashMap<>();

    public void addDelegate(String tokenType, TokenStore delegate) {
        delegates.put(tokenType, delegate);
    }

    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        // Implementation to read the access token from the appropriate delegate
        return delegates.values().stream()
                .map(delegate -> delegate.readAccessToken(tokenValue))
                .filter(accessToken -> accessToken != null)
                .findFirst()
                .orElse(null);
    }

    @Override
    public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
        // Implementation to get the access token from the appropriate delegate
        return delegates.values().stream()
                .map(delegate -> delegate.getAccessToken(authentication))
                .filter(accessToken -> accessToken != null)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        // Implementation to store the access token in the appropriate delegate
        delegates.values().forEach(delegate -> delegate.storeAccessToken(token, authentication));
    }

    @Override
    public void removeAccessToken(OAuth2AccessToken token) {
        // Implementation to remove the access token from the appropriate delegate
        delegates.values().forEach(delegate -> delegate.removeAccessToken(token));
    }

    @Override
    public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
        // Implementation to store the refresh token in the appropriate delegate
        delegates.values().forEach(delegate -> delegate.storeRefreshToken(refreshToken, authentication));
    }

    @Override
    public OAuth2RefreshToken readRefreshToken(String tokenValue) {
        // Implementation to read the refresh token from the appropriate delegate
        return delegates.values().stream()
                .map(delegate -> delegate.readRefreshToken(tokenValue))
                .filter(refreshToken -> refreshToken != null)
                .findFirst()
                .orElse(null);
    }

    @Override
    public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
        // Implementation to read the authentication for refresh token from the appropriate delegate
        return delegates.values().stream()
                .map(delegate -> delegate.readAuthenticationForRefreshToken(token))
                .filter(authentication -> authentication != null)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void removeRefreshToken(OAuth2RefreshToken token) {
        // Implementation to remove the refresh token from the appropriate delegate
        delegates.values().forEach(delegate -> delegate.removeRefreshToken(token));
    }

    @Override
    public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {
        // Implementation to remove the access token using the refresh token from the appropriate delegate
        delegates.values().forEach(delegate -> delegate.removeAccessTokenUsingRefreshToken(refreshToken));
    }

    @Override
    public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
        // Implementation to read the authentication from the appropriate delegate
        return delegates.values().stream()
                .map(delegate -> delegate.readAuthentication(token))
                .filter(authentication -> authentication != null)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
        // Implementation to find tokens by client ID and username from the appropriate delegate
        return delegates.values().stream()
                .map(delegate -> delegate.findTokensByClientIdAndUserName(clientId, userName))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
        // Implementation to find tokens by client ID from the appropriate delegate
        return delegates.values().stream()
                .map(delegate -> delegate.findTokensByClientId(clientId))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}