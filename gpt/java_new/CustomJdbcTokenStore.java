import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

public class CustomJdbcTokenStore extends JdbcTokenStore {

    public CustomJdbcTokenStore(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        super.storeAccessToken(token, authentication);
        // Your custom code goes here (after storing the token)
        onAccessTokenCreated(token, authentication);
    }

    @Override
    public void removeAccessToken(OAuth2AccessToken token) {
        super.removeAccessToken(token);
        // Your custom code goes here (after removing the token)
        onAccessTokenRemoved(token);
    }

    private void onAccessTokenCreated(OAuth2AccessToken token, OAuth2Authentication authentication) {
        // Custom logic for when a new access token is created
    }

    private void onAccessTokenRemoved(OAuth2AccessToken token) {
        // Custom logic for when an access token is removed
    }
}