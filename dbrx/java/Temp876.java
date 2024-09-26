import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@SpringBootApplication
public class Temp876 {
    public static void main(String[] args) {
        SpringApplication.run(Temp876.class, args);
    }

    @Bean
    public JwtAccessTokenConverter jwtTokenEnhancer() {
        String secret = "mySecret";
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(secret);
        return converter;
    }
}