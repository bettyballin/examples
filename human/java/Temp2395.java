import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.context.annotation.Bean;

public class Temp2395 extends ResourceServerConfigurerAdapter {
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(tokenServices());
        resources.resourceId("your-resource-id"); // replace with the actual resource ID from the aud claim
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public CustomTokenServices tokenServices() {
        CustomTokenServices tokenServices = new CustomTokenServices();
        tokenServices.setTokenStore(tokenStore());
        return tokenServices;
    }

    @Bean
    public CustomAccessTokenConverter accessTokenConverter() {
        CustomAccessTokenConverter converter = new CustomAccessTokenConverter();
        converter.setSigningKey("your-signing-key"); // replace with your actual signing key
        return converter;
    }
    
    // Custom classes for demonstration purposes
    public static class CustomTokenServices extends org.springframework.security.oauth2.provider.token.DefaultTokenServices {
        // Custom implementation if needed
    }

    public static class CustomAccessTokenConverter extends org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter {
        // Custom implementation if needed
    }

    public static void main(String[] args) {
        // Main method implementation if needed
    }
}