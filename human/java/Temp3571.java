import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;

@Configuration
public class JwtDecoderConfig {

    @Bean
    public ReactiveJwtDecoder jwtDecoder(@Value("${ISSUER_URI}") String issuerUri,
                                         @Value("${JWKS_URI}") String jwksUri) {

        HttpClient httpClient = HttpClient.create().proxyWithSystemProperties();
        WebClient webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        var jwtDecoder = NimbusReactiveJwtDecoder
                .withJwkSetUri(jwksUri)
                .webClient(webClient)
                .build();

        jwtDecoder.setJwtValidator(JwtValidators.createDefaultWithIssuer(issuerUri));
        return jwtDecoder;
    }

    public static void main(String[] args) {
        // Placeholder for main application logic if needed
    }
}