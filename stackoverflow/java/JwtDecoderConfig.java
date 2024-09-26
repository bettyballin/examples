import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.client.HttpClientProperties;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import reactor.netty.tcp.ProxyProvider;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;

public class JwtDecoderConfig {

    @Bean
    public ReactiveJwtDecoder jwtDecoder(@Value("${ISSUER_URI}") String issuerUri,
                                         @Value("${JWKS_URI}") String jwksUri) {

        HttpClient httpClient = HttpClient.create().proxyWithSystemProperties();
        WebClient webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        NimbusReactiveJwtDecoder jwtDecoder = NimbusReactiveJwtDecoder
                .withJwkSetUri(jwksUri)
                .webClient(webClient)
                .build();

        jwtDecoder.setJwtValidator(JwtValidators.createDefaultWithIssuer(issuerUri));

        return jwtDecoder;
    }
}