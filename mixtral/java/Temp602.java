import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.web.filter.GenericFilterBean;

@SpringBootApplication
@EnableResourceServer
public class Temp602 {

    @Autowired
    private ResourceServerTokenServices tokenService;

    public static void main(String[] args) {
        SpringApplication.run(Temp602.class, args);
    }

    @Bean
    public GenericFilterBean oauthResourceServerFilter() {
        OAuth2AuthenticationProcessingFilter filter = new OAuth2AuthenticationProcessingFilter();

        // Set the resource server's Token Services
        filter.setTokenExtractor(new BearerTokenExtractor());

        // Configure token services
        DefaultAccessTokenConverter accessTokenConverter = (DefaultAccessTokenConverter) tokenService;

        JwtAccessTokenConverter jwtTokenEnhancer = new JwtAccessTokenConverter();

        filter.setAuthenticationManager(new OAuth2AuthenticationManager());

        return filter;
    }
}