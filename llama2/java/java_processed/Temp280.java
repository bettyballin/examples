import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Temp280 {
    public static void main(String[] args) {
        SpringApplication.run(Temp280.class, args);
    }

    @Bean
    public OAuth2AuthorizationServer authorizationServer() {
        OAuth2AuthorizationServer authorizationServer = new OAuth2AuthorizationServer();
        authorizationServer.setTokenServices(tokenServices());
        authorizationServer.setUserInfoEndpointUrl("http://zuul-api-gateway.com/login");
        return authorizationServer;
    }

    @Bean
    public TokenServices tokenServices() {
        return new TokenServices();
    }
}

class OAuth2AuthorizationServer {
    private TokenServices tokenServices;
    private String userInfoEndpointUrl;

    public void setTokenServices(TokenServices tokenServices) {
        this.tokenServices = tokenServices;
    }

    public void setUserInfoEndpointUrl(String userInfoEndpointUrl) {
        this.userInfoEndpointUrl = userInfoEndpointUrl;
    }
}

class TokenServices {
    // Token services implementation
}