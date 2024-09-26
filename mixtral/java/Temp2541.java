import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.security.interfaces.RSAPublicKey;

@SpringBootApplication
public class Temp2541 {

    private RSAPublicKey yourPublicKey; // Replace with your actual public key

    public static void main(String[] args) {
        SpringApplication.run(Temp2541.class, args);
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(yourPublicKey).build();
    }

    // Application properties configuration
    // Create a file named 'application.yml' in src/main/resources with the following content:
    /*
    spring:
      security:
        oauth2:
          resourceserver:
            jwt:
              issuer-uri: http://localhost:8091
    */
}