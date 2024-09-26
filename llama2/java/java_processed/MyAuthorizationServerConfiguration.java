import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class MyAuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("client")
            .secret("{noop}my_secret_password")
            .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
            .scopes("read", "write")
            .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT", "ROLE_USER");
    }
}