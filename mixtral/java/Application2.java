import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootApplication
public class Application {

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {

        // Get the encoded key from your properties file
        String base64EncodedKey = environment.getProperty("security.oauth2.resource.jwt.key-value");

        byte[] decodedKeyBytes = Base64.getUrlDecoder().decode(base64EncodedKey);

        // Convert the bytes to a string
        String keyString = new String(decodedKeyBytes, StandardCharsets.UTF_8);

        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(keyString);

        return converter;
    }
}