import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestValidator;
import org.springframework.security.oauth2.provider.request.OAuth2RequestValidator;

public class Temp2125 {
    private OAuth2RequestValidator oAuth2RequestValidator = new DefaultOAuth2RequestValidator();

    public static void main(String[] args) {
        Temp2125 temp = new Temp2125();
        System.out.println("OAuth2RequestValidator initialized: " + (temp.oAuth2RequestValidator != null));
    }
}