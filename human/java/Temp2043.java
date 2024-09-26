import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@SpringBootApplication
public class Temp2043Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp2043Application.class, args);
    }

    @RestController
    @RequestMapping("/token")
    public static class TokenController {

        @Autowired
        protected TokenStore tokenStore;

        @PostMapping("/revoke")
        public void revokeToken(@RequestParam String token) {
            ((InMemoryTokenStore) tokenStore).removeRefreshToken(token);
        }
    }
}