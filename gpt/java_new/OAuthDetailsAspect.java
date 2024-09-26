import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Aspect
@Component
public class OAuthDetailsAspect {

    @SuppressWarnings("unchecked")
    @Before("execution(* your.package..*Controller.*(..)) && args(authentication,..)")
    public void addOAuthDetailsToModel(JoinPoint joinPoint, Authentication authentication) {
        if (authentication != null && authentication.getDetails() instanceof OAuth2AuthenticationDetails) {
            OAuth2AuthenticationDetails oauthDetails = (OAuth2AuthenticationDetails) authentication.getDetails();
            HashMap<String, Object> additionalInformationMap = (HashMap<String, Object>) oauthDetails.getDecodedDetails();
            // Continue with the rest of the method implementation...
        }
    }
}