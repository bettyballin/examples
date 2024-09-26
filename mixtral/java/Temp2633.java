import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

@EnableAuthorizationServer
public class Temp2633 {
    
    @Autowired
    private KeyPair keyPair;

    public static void main(String[] args) {
        // Application start logic, if necessary
    }

    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // Configure the client details
    }

    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey((RSAPublicKey) this.keyPair.getPublic()).build();
    }
}