import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Temp1042 {

    @Autowired
    private TokenStore tokenStore;

    public static void main(String[] args) {
        SpringApplication.run(Temp1042.class, args);
    }

    @GetMapping("/tokens")
    public List<OAuth2AccessToken> findTokensByUserName(@RequestParam String userName) {
        return this.tokenStore.findTokensByClientIdAndUserName("client_id", userName);
    }
}