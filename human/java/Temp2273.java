import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

public class Temp2273 extends AuthorizationServerConfigurerAdapter {
    private final AuthenticationManager authenticationManager;
    private final TokenStore tokenStore;

    public Temp2273(AuthenticationManager authenticationManager, TokenStore tokenStore) {
        this.authenticationManager = authenticationManager;
        this.tokenStore = tokenStore;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
             .authenticationManager(authenticationManager)
             .tokenStore(tokenStore);
    }

    public static void main(String[] args) {
        // Spring Boot application would typically start here
        // This is a placeholder for where the application would be configured and started
        System.out.println("Application started");
    }

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        // Return a mock AuthenticationManager for the sake of the example
        return authentication -> authentication;
    }
}