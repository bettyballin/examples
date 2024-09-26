import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
public class SecurityConfig106 {

    private final Environment environment;

    public SecurityConfig106(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        String base64EncodedKey = environment.getProperty("security.oauth2.resource.jwt.key-value");
        if (base64EncodedKey != null) {
            converter.setSigningKey(base64EncodedKey);
        }
        return converter;
    }
}