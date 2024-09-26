import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class OAuth2TokenService {
    @Value("${oauth2.clientId}")
    private String clientId;

    @Value("${oauth2.clientSecret}")
    private String clientSecret;

    @Value("${oauth2.accessTokenUri}")
    private String accessTokenUri;

    private String accessToken;
    private long expiryTime;

    // This method should be implemented to interact with the OAuth2 server
    public String getAccessToken() {
        // Dummy implementation for the sake of example
        if (System.currentTimeMillis() > expiryTime) {
            // Logic to obtain new access token
            // accessToken = ...;
            // expiryTime = ...;
        }
        return accessToken;
    }
}