import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

public class Temp1598 {
    public static void main(String[] args) {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        
        enhancerChain.setTokenEnhancers(Arrays.asList((TokenEnhancer) accessTokenConverter));
        
        System.out.println("Token Enhancer Chain configured successfully!");
    }
}