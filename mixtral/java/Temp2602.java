import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoders;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.oauth2.server.resource.introspection.OAuth2IntrospectionAuthenticationToken;
import org.springframework.security.oauth2.server.resource.web.server.ServerBearerTokenAuthenticationConverter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Temp2602 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2602.class, args);
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        // Return a dummy JwtDecoder for example purposes
        return NimbusReactiveJwtDecoders.fromIssuerLocation("http://localhost:8080");
    }

    @Bean
    public JwtDecoder jwtDecoder(OAuth2ResourceServerProperties properties) throws Exception {
        NimbusReactiveJwtDecoder jwtDecoder = NimbusReactiveJwtDecoders.fromIssuerLocation(properties.getJwt().getIssuerUri());
        return jwtDecoder;
    }
}