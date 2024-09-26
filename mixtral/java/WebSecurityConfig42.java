import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.server.resource.authentication.OAuth2AuthenticationManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, OAuth2AuthenticationManager oauth2AuthenticationManager) throws Exception {
        return http
                .authorizeRequests()
                    // Add your global authorization rules here
                    .anyRequest().authenticated()
                    .and()
                .oauth2ResourceServer((resourceServer) -> resourceServer
                        .opaqueToken(configurer -> configurer.authenticationManager(oauth2AuthenticationManager)))
                .build();
    }
}