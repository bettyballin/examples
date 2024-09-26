import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class OAuthService {
    public OAuth2AccessToken refreshToken(String refreshTokenValue, String clientId, String clientSecret, String accessTokenUri) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("grant_type", "refresh_token");
        requestParams.add("client_id", clientId);
        requestParams.add("client_secret", clientSecret);
        requestParams.add("refresh_token", refreshTokenValue);

        return restTemplate.postForObject(accessTokenUri, requestParams, OAuth2AccessToken.class);
    }
}