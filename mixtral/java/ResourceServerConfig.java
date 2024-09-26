import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        DefaultAccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();

        // Configure your custom TokenEnhancer
        CustomTokenEnhancer enhancer = new CustomTokenEnhancer();
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setAccessTokenConverter(tokenConverter);
        jwtAccessTokenConverter.setEnhancer(enhancer);

        return jwtAccessTokenConverter;
    }

    // Dummy CustomTokenEnhancer class for compilation
    public static class CustomTokenEnhancer extends JwtAccessTokenConverter {
        // Custom implementation here
    }
}