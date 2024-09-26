import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@Configuration
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("client-id")
            .secret("{noop}client-secret")  // Using {noop} for plain text secret
            .authorizedGrantTypes("authorization_code", "refresh_token", "password", "client_credentials")
            .scopes("read")
            .authorities("ROLE_USER", "SCOPE_READ");

        super.configure(clients);
    }
}