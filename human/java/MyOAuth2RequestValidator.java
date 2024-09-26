import org.springframework.security.oauth2.provider.OAuth2RequestValidator;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.ClientDetails;

public class MyOAuth2RequestValidator implements OAuth2RequestValidator {
    @Override
    public void validateScope(OAuth2Request oauth2Request, ClientDetails client) throws InvalidScopeException {
        // Implement your scope validation logic here
        String requestedScope = oauth2Request.getScope().toString();
        String clientScope = client.getScope().toString();

        if (!clientScope.contains(requestedScope)) {
            throw new InvalidScopeException("Requested scope is not allowed for this client");
        }
    }
}