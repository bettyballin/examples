import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.server.resource.authentication.OpaqueTokenAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.OAuth2AuthenticationManager;

@Configuration
public class BearerAuthWebSecurityConfig {

    @Bean
    public SecurityFilterChain resourceServerFilterChain(HttpSecurity http, OAuth2AuthenticationManager authManager) throws Exception {
        return http
                .antMatcher("/api/**")
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .oauth2ResourceServer((resourceServer) -> resourceServer
                        .opaqueToken((configurer) -> configurer.authenticationManager(authManager)))
                .build();
    }

    @Bean
    public OAuth2AuthenticationManager authenticationManager(OpaqueTokenAuthenticationProvider opaqueTokenAuthenticationProvider) {
        OAuth2AuthenticationManager authenticationManager = new OAuth2AuthenticationManager(opaqueTokenAuthenticationProvider);
        return authenticationManager;
    }

    @Bean
    public OpaqueTokenAuthenticationProvider opaqueTokenAuthenticationProvider() {
        // Configure the OpaqueTokenAuthenticationProvider bean here
        return new OpaqueTokenAuthenticationProvider();
    }
}