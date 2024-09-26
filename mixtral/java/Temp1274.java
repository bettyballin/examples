import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@SpringBootApplication
public class Temp1274 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1274.class, args);
    }

    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {
        String signingKey = "your_secret_key"; // replace with a secure secret key

        byte[] encodedSecretBytes = Base64.getEncoder().encode(signingKey.getBytes());

        SecretKeySpec signingKeySpec = new SecretKeySpec(encodedSecretBytes, 0, encodedSecretBytes.length, "HmacSHA256");

        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

        // Set the signing key
        converter.setSigningKey(Base64.getEncoder().encodeToString(signingKeySpec.getEncoded()));

        return converter;
    }
}