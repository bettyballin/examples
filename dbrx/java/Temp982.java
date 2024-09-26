import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

@SpringBootApplication
public class Temp982 {
    public static void main(String[] args) {
        SpringApplication.run(Temp982.class, args);
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public AccessTokenConverter accessTokenConverter() {
        DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();
        defaultAccessTokenConverter.setUserTokenConverter(userAuthenticationConverter());
        return defaultAccessTokenConverter;
    }

    @Bean
    public UserAuthenticationConverter userAuthenticationConverter() {
        return new DefaultUserAuthenticationConverter();
    }

    @Bean
    public org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory keyStoreKeyFactory() {
        org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory keyStoreKeyFactory = new org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory(new java.io.ClassPathResource("jwt.jks"), "password".toCharArray());
        keyStoreKeyFactory.setKeyPairAlias("jwt");
        return keyStoreKeyFactory;
    }
}