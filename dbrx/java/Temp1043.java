import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Temp1043 {

    @Autowired
    private TokenStore tokenStore;

    public static void main(String[] args) {
        SpringApplication.run(Temp1043.class, args);
    }

    public List<OAuth2AccessToken> findTokensByUserName(String userName) {
        return this.tokenStore.getClientIds().stream()
            .map(clientId -> this.tokenStore.findTokensByClientIdAndUserName(clientId, userName))
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }
}

@Configuration
class AppConfig {

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
}