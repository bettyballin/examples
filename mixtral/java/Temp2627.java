import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import java.security.interfaces.RSAPublicKey;

@SpringBootApplication
public class Temp2627 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2627.class, args);
    }

    @Bean
    public JwtDecoder jwtDecoder(RSAPublicKey yourPublicKey) {
        return NimbusJwtDecoder
                .withPublicKey(yourPublicKey)
                .build();
    }
}