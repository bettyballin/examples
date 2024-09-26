import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        final InMemoryClientDetailsService clientDetails = new InMemoryClientDetailsService();

        BaseClientDetails firstApp = new BaseClientDetails("first_app", null, "readwrite",
                "client_credentials,password", "/oauth/token");

        BaseClientDetails secondApp = new BaseClientDetails("second_app", null, "read",
                "authorization_code,implicit", "http://localhost:8091/*");

        clientDetails.setClientDetailsStore(Map.of(
            firstApp.getClientId(), firstApp,
            secondApp.getClientId(), secondApp
        ));

        clients
            .withClientDetails(clientDetails);
    }
}