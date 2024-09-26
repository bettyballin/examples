import java.util.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class OAuthClient {
    public static void main(String[] args) {
        final String clientId = "yourClientId";
        final String clientSecret = "yourClientSecret";
        final String grantType = "yourGrantType";
        final String username = "yourUsername";
        final String password = "yourPassword";
        final String tokenUrl = "yourTokenUrl";

        String authorizationHeader = "Basic " + Base64.getEncoder()
                .encodeToString((clientId + ":" + clientSecret).getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationHeader);
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", grantType);
        body.add("username", username);
        body.add("password", password);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<TokenResponse> response =
                restTemplate.postForEntity(tokenUrl, request, TokenResponse.class);

        TokenResponse tokenResponse = response.getBody();
        System.out.println("Access Token: " + tokenResponse.getAccessToken());
    }
}

class TokenResponse {
    private String access_token;

    // Getters and setters

    public String getAccessToken() {
        return access_token;
    }

    public void setAccessToken(String accessToken) {
        this.access_token = accessToken;
    }
}