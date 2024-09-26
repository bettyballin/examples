import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@Configuration
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthServerConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("egen")
                .secret("{noop}egensecret")
                .authorizedGrantTypes("authorization_code", "refresh_token", "password")
                .scopes("food_read", "food_write")
            .and()
                .withClient("oauthclient")
                .secret("{noop}oauthclient-secret")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .authorities("ROLE_USER", "ROLE_OPERATOR")
                .scopes("food_read");
    }
///more code
}