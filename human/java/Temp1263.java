import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
public class AppConfig {

    private final TokenStore tokenStore;

    public AppConfig(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Bean
    public TokenStoreUserApprovalHandler userApprovalHandler() {
        TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
        handler.setTokenStore(tokenStore);
        return handler;
    }
}