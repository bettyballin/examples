import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import java.util.Arrays;

public class TokenConfig {

    @Autowired
    private JwtAccessTokenConverter accessTokenConverter;

    public void setupTokenEnhancerChain() {
        TokenEnhancer tokenEnhancer = accessTokenConverter;
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        enhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer));
    }
}