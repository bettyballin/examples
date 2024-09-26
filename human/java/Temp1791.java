import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.authentication.AuthenticationManager;

public class Temp1791 {
    private AuthenticationManager authenticationManager;

    public static void main(String[] args) {
        Temp1791 temp = new Temp1791();
        AuthorizationServerEndpointsConfigurer endpoints = new AuthorizationServerEndpointsConfigurer();
        try {
            temp.configure(endpoints);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenServices(tokenServices()).authenticationManager(authenticationManager);
    }

    private DefaultTokenServices tokenServices() {
        return new DefaultTokenServices();
    }
}