import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

public class CustomDefaultTokenServices extends DefaultTokenServices {

    private TokenStore jwtAccessTokenStore;

    public TokenStore getJwtAccessTokenStore() {
        return jwtAccessTokenStore;
    }

    public void setJwtAccessTokenStore(TokenStore jwtAccessTokenStore) {
        this.jwtAccessTokenStore = jwtAccessTokenStore;
    }
}