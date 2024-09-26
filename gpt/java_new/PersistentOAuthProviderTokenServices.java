import org.springframework.security.oauth.provider.OAuthProviderToken;
import org.springframework.security.oauth.provider.token.AbstractProviderTokenServices;

public class PersistentOAuthProviderTokenServices extends AbstractProviderTokenServices {

    private YourTokenRepository tokenRepository; // Your custom token repository

    public void setTokenRepository(YourTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    protected void storeToken(String tokenId, OAuthProviderToken token) {
        // Persist the token using your custom method
        tokenRepository.storeToken(tokenId, token);
    }

    @Override
    protected OAuthProviderToken removeToken(String tokenId) {
        // Remove the token from your persistent store and return it
        return tokenRepository.removeToken(tokenId);
    }

    @Override
    protected OAuthProviderToken getToken(String tokenId) {
        // Retrieve the token from your persistent store
        return tokenRepository.getToken(tokenId);
    }
}

interface YourTokenRepository {
    void storeToken(String tokenId, OAuthProviderToken token);
    OAuthProviderToken removeToken(String tokenId);
    OAuthProviderToken getToken(String tokenId);
}