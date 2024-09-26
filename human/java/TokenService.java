import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class TokenService {
    private static final Logger log = LoggerFactory.getLogger(TokenService.class);

    private final TokenServiceProperties tokenServiceProperties;
    private final RestTemplate simpleRestTemplate;
    private OAuth2AccessToken tokenCache;

    public TokenService(TokenServiceProperties tokenServiceProperties) {
        this.tokenServiceProperties = tokenServiceProperties;
        this.simpleRestTemplate = new RestTemplateBuilder().build();
    }

    public OAuth2AccessToken getRefreshedToken() {
        if (tokenCache == null || tokenCache.isExpired()) {
            log.debug("Token expired, fetching new token");
            tokenCache = refreshOAuthToken();
        } else {
            log.debug("Token still valid for {} seconds", tokenCache.getExpiresIn());
        }
        return tokenCache;
    }

    public OAuth2AccessToken loginWithCredentials(String username, String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "password");
        map.add("resource", tokenServiceProperties.getAadB2bResource());
        map.add("client_id", tokenServiceProperties.getAadB2bClientId());
        map.add("username", username);
        map.add("password", password);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        return simpleRestTemplate.postForObject(
                tokenServiceProperties.getAadB2bUrl(),
                request,
                OAuth2AccessToken.class
        );
    }

    private OAuth2AccessToken refreshOAuthToken() {
        return loginWithRefreshToken(tokenCache.getRefreshToken().getValue());
    }

    public OAuth2AccessToken loginWithRefreshToken(String refreshToken) {
        // Implement the method to fetch OAuth2 token using refresh token
        return null;
    }
}

class TokenServiceProperties {
    public String getAadB2bResource() {
        // Implement this method to return the AAD B2B resource
        return null;
    }

    public String getAadB2bClientId() {
        // Implement this method to return the AAD B2B client ID
        return null;
    }

    public String getAadB2bUrl() {
        // Implement this method to return the AAD B2B URL
        return null;
    }
}

class OAuth2AccessToken {
    public boolean isExpired() {
        // Implement this method to check if the token is expired
        return false;
    }

    public int getExpiresIn() {
        // Implement this method to return the number of seconds until the token expires
        return 0;
    }

    public RefreshToken getRefreshToken() {
        // Implement this method to return the refresh token
        return new RefreshToken();
    }
}

class RefreshToken {
    public String getValue() {
        // Implement this method to return the value of the refresh token
        return null;
    }
}