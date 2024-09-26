import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public AuthorizationServerConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
            .inMemory()
            .withClient("client1")
            .authorizedGrantTypes("password", "refresh_token")
            .scopes("read", "write")
            .resourceIds("resource_id_1")
            .secret(passwordEncoder.encode("secret1"))
            .and()
            .withClient("client2")
            .authorizedGrantTypes("password", "refresh_token")
            .scopes("read", "write")
            .resourceIds("resource_id_2")
            .secret(passwordEncoder.encode("secret2"));
    }
}