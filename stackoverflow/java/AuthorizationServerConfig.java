// Original snippet is not valid Java code on its own. It seems to be a part of a Spring Security OAuth2 configuration.
// Since there's not enough context provided, I'll assume it's a part of a larger configuration method.
// Here is a possible refactoring within a configuration method to compile successfully.

import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public AuthorizationServerConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("web")
            .authorizedGrantTypes("password")
            .secret(passwordEncoder.encode("webclientsecret"));
            // ... additional configuration
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // ... configure endpoints
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // ... configure security
    }
}