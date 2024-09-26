import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class TokenServicesConfig {

    private TokenStore tokenStore;
    private TokenEnhancer tokenEnhancer;

    public TokenServicesConfig(TokenStore tokenStore, TokenEnhancer tokenEnhancer) {
        this.tokenStore = tokenStore;
        this.tokenEnhancer = tokenEnhancer;
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore);
        defaultTokenServices.setSupportRefreshToken(true);
        defaultTokenServices.setTokenEnhancer(tokenEnhancer);
        defaultTokenServices.setAccessTokenValiditySeconds(100);
        return defaultTokenServices;
    }
}