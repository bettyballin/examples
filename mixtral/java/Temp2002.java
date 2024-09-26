import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class Temp2002 {
    public static void main(String[] args) {

        // Mock the apiProperties and refreshToken for demonstration purposes
        ApiProperties apiProperties = new ApiProperties();
        String refreshToken = "mockRefreshToken";

        DefaultOAuth2AccessTokenResponseClient responseClient =
                new DefaultOAuth2AccessTokenResponseClient();

        String url = apiProperties.getBaseUrl() + OAUTH_TOKEN_PATH;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "refresh_token");
        formData.add("client_id", apiProperties.getClientId());
        formData.add("client_secret", apiProperties.getClientSecret());
        formData.add("refresh_token", refreshToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);

        OAuth2AccessTokenResponse response;
        try {
            response = responseClient.getTokenResponse(url, request);
        } catch (Exception e) {
            // Handle exception
            System.out.println("Exception occurred while getting token response: " + e.getMessage());
            return;
        }

        // Extract the access token from OAuth2AccessTokenResponse
        String newAccessToken = response.getOauthToken().getValue();
        System.out.println("New Access Token: " + newAccessToken);
    }
}

// Mock classes for demonstration purposes
class ApiProperties {
    public String getBaseUrl() {
        return "http://example.com";
    }

    public String getClientId() {
        return "clientId";
    }

    public String getClientSecret() {
        return "clientSecret";
    }
}

class DefaultOAuth2AccessTokenResponseClient {
    public OAuth2AccessTokenResponse getTokenResponse(String url, HttpEntity<MultiValueMap<String, String>> request) {
        // Mock response for demonstration purposes
        return new OAuth2AccessTokenResponse();
    }
}

class OAuth2AccessTokenResponse {
    public OauthToken getOauthToken() {
        // Mock token for demonstration purposes
        return new OauthToken();
    }
}

class OauthToken {
    public String getValue() {
        return "mockAccessToken";
    }
}