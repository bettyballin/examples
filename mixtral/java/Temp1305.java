import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.stereotype.Component;

@Component
public class Temp1305 {

    @Autowired
    private InMemoryTokenStore tokenStore;

    public static void main(String[] args) {
        Temp1305 temp = new Temp1305();
        temp.config();
    }

    public void config() {
        tokenStore = new InMemoryTokenStore();
        // Perform further configuration or usage of tokenStore here
        System.out.println("TokenStore configured: " + tokenStore);
    }
}