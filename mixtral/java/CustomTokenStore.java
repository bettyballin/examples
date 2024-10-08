import org.springframework.http.*;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class CustomTokenStore implements TokenStore {
    private final String checkTokenUrl;

    public CustomTokenStore(String checkTokenUrl) {
        this.checkTokenUrl = checkTokenUrl;
    }

    @Override
    public OAuth2Authentication readAccessToken(String tokenValue) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("token", tokenValue);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<OAuth2AccessToken> response = restTemplate
                .exchange(checkTokenUrl,
                          HttpMethod.POST,
                          request,
                          OAuth2AccessToken.class);

       return convertAccessTokenToAuthentication(response.getBody());
    }

    private OAuth2Authentication convertAccessTokenToAuthentication(OAuth2AccessToken accessToken) {
        // Implement conversion logic here
        return null; // Replace with actual implementation
    }

    // Implement other TokenStore methods as needed
    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) { return null; }

    @Override
    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {}

    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) { return null; }

    @Override
    public void removeAccessToken(OAuth2AccessToken token) {}

    @Override
    public OAuth2Authentication readAuthentication(OAuth2AccessToken token) { return null; }

    @Override
    public OAuth2Authentication readAuthentication(String token) { return null; }

    @Override
    public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {}

    @Override
    public OAuth2RefreshToken readRefreshToken(String tokenValue) { return null; }

    @Override
    public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) { return null; }

    @Override
    public void removeRefreshToken(OAuth2RefreshToken token) {}

    @Override
    public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {}

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) { return null; }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) { return null; }
}