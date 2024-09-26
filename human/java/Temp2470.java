import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

@SpringBootApplication
public class Temp2470 {

    @Autowired
    private JwtAccessTokenConverter accessTokenConverter;

    public static void main(String[] args) {
        SpringApplication.run(Temp2470.class, args);
    }

    @Autowired
    public void configureTokenEnhancers() {
        TokenEnhancer tokenEnhancer = accessTokenConverter; // Added this
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        enhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer)); // and add the enhancer here
    }
}