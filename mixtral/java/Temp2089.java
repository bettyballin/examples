import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.oauth2.jwt.JwtDecoders;

public class Temp2089 {
    public static void main(String[] args) {
        // Main method can be empty if we are not executing anything specific
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        // @formatter:off
        return http
            .authorizeExchange()
                .anyExchange().authenticated()
            .and()
            .oauth2ResourceServer()
                .jwt()
                    .decoder(JwtDecoders.fromIssuerLocation("https://securetoken.google.com/{app.name}"))
            .and()
            .build();
        // @formatter:on
    }
}