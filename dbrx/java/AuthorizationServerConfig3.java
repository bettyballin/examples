import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.http.HttpStatus;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig {

    @Bean
    public SecurityConfigurer<SecurityBuilder, SecurityConfigurerAdapter> authorizationServerSecurityConfigurer() {
        return new SecurityConfigurerAdapter<SecurityBuilder>() {
            @Override
            public void configure(SecurityBuilder builder) throws Exception {
                builder.authenticationEntryPoint(customAuthenticationEntryPoint());
            }
        };
    }

    private AuthenticationEntryPoint customAuthenticationEntryPoint() {
        return new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED);
    }
}