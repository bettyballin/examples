import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

@SpringBootApplication
public class Temp2635 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2635.class, args);
    }

    @Bean
    public JwtDecoder jwtDecoder(OAuth2ResourceServerProperties properties) {
        NimbusJwtDecoder decoder = (NimbusJwtDecoder)
                JwtDecoders.fromIssuerLocation(properties.getJwt().getIssuerUri());

        // Add custom claims converter if needed

        return decoder;
    }
}