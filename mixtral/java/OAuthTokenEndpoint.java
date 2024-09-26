import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;

@RestController
@RequestMapping("/oauth")
public class OAuthTokenEndpoint {

    private final TokenEndpoint tokenEndpoint;

    public OAuthTokenEndpoint(TokenEndpoint tokenEndpoint) {
        this.tokenEndpoint = tokenEndpoint;
    }

    @PostMapping(value = "/token", produces = "application/json")
    public ResponseEntity<OAuth2AccessToken> postAccessToken() throws AuthenticationException {
        // Implementation of token generation logic goes here
        // This is just a placeholder to make the code executable
        try {
            OAuth2AccessToken token = tokenEndpoint.postAccessToken(null, null).getBody();
            return ResponseEntity.ok(token);
        } catch (OAuth2Exception e) {
            throw new AuthenticationException("Error generating token") {};
        }
    }
}