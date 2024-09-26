import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Service;

@Service
public class CustomTokenServices extends DefaultTokenServices {
    @Override
    public void validateClient(ClientDetails client) {
        // Custom validation logic
    }
}