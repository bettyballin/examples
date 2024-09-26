import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class CustomResourceServerSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        BearerTokenAuthenticationEntryPoint bearerTokenAuthenticationEntryPoint = new CustomBearerTokenAuthenticationEntryPoint();

        http.oauth2ResourceServer(oauth2 ->
                oauth2.opaqueToken(opaque ->
                        opaque.introspectionUri("https://introspection.uri")
                                .introspectionClientCredentials("client-id", "client-secret")
                ).authenticationEntryPoint(bearerTokenAuthenticationEntryPoint)
        );
        http.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated());
        return http.build();
    }
}

class CustomBearerTokenAuthenticationEntryPoint extends BearerTokenAuthenticationEntryPoint {
    // Custom implementation here
}