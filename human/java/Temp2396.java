import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public class Temp2396 {
    public static void main(String[] args) {
        new Temp2396().apply(new RequestTemplate());
    }

    public void apply(RequestTemplate template) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            String tokenValue = null;
            if (auth.getDetails() instanceof OAuth2AuthenticationDetails) {
                OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) auth.getDetails();
                tokenValue = details.getTokenValue();
            } else if (auth.getDetails() instanceof InternalOAuth2Details) {
                InternalOAuth2Details details = (InternalOAuth2Details) auth.getDetails();
                tokenValue = details.getTokenValue();
            }
            if (tokenValue == null) {
                System.out.println("Current token value is null");
                return;
            }
            template.header("Authorization", "Bearer " + tokenValue);
        }
    }

    class RequestTemplate {
        public void header(String name, String value) {
            System.out.println(name + ": " + value);
        }
    }

    class InternalOAuth2Details {
        public String getTokenValue() {
            return "internalToken";
        }
    }
}