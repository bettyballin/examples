import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .secret("{noop}password")
                .authorizedGrantTypes("authorization_code", "refresh_token", "password")
                .scopes("read", "write", "trust")
                .accessTokenValiditySeconds(60)
                .and()
                .withClient("client2")
                .secret("{noop}password2")
                .authorizedGrantTypes("authorization_code", "refresh_token", "password")
                .scopes("read", "write", "trust")
                .accessTokenValiditySeconds(120);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        TokenEnhancerChain chain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = Arrays.asList(new CustomTokenEnhancer(), accessTokenConverter());
        chain.setTokenEnhancers(delegates);
        endpoints.tokenEnhancer(chain);
    }

    public TokenEnhancer accessTokenConverter() {
        // Custom implementation of TokenEnhancer
        return new CustomTokenEnhancer();
    }

    public static class CustomTokenEnhancer implements TokenEnhancer {
        // Custom token enhancer implementation
    }
}