import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
public class Temp1080 extends AuthorizationServerConfigurerAdapter {
    public static void main(String[] args) {
        // This main method is not necessary for Spring Authorization Server configuration
        // Spring Application context will bootstrap the configuration
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("web")
            .secret("{noop}webclientsecret")
            .authorizedGrantTypes("password")
            .scopes("read", "write");
    }
}