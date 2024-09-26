import org.springframework.security.oauth2.provider.authentication.DefaultOAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        OAuth2AuthenticationDetails details = createMockOauth2AuthenticationDetails();
        System.out.println(details);
    }

    private static OAuth2AuthenticationDetails createMockOauth2AuthenticationDetails() {
        return new TestOAuth2AuthenticationDetails(new HashMap<>());
    }

    // You can extend the `TestOAuth2AuthenticationDetails` class if you need more customization
    public static final class TestOAuth2AuthenticationDetails extends DefaultOAuth2AuthenticationDetails {
        
        public TestOAuth2AuthenticationDetails(HashMap<String, Object> map) {
            super(map);
        }
    }
}