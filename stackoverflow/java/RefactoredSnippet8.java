import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.Map;

public class RefactoredSnippet8 {
    public void printCustomClaim() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();        
        Object details = authentication.getDetails();        
        if (details instanceof OAuth2AuthenticationDetails) {
            OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) details;
        
            Map<String, Object> decodedDetails = (Map<String, Object>) oAuth2AuthenticationDetails.getDecodedDetails();
        
            System.out.println("My custom claim value: " + decodedDetails.get("MyClaim"));
        }  
    }
}