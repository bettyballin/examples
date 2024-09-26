import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import java.util.Arrays;

public class TokenEnhancerConfigurer {

    private TokenEnhancerChain enhancerChain;

    @Autowired
    private TokenEnhancer accessTokenConverter;

    public TokenEnhancerConfigurer() {
        enhancerChain = new TokenEnhancerChain();
        enhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter));
    }
}