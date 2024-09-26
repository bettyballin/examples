import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserRestController {

    @Autowired
    private OAuthClientConfig oAuthClientConfig;

    @Autowired
    private UserCredentialService userCredentialService;

    @PostMapping("/user")
    public OAuth2AccessToken createUserCredential(@RequestBody UserCredential user, HttpServletRequest request) {
        user.validate();
        userCredentialService.checkAndSaveUser(user, getClientIp(request));
        
        OAuth2RestOperations restTemplate = oAuthClientConfig.restTemplate();
        restTemplate.getOAuth2ClientContext().getAccessTokenRequest().set("username", user.getLogin());
        restTemplate.getOAuth2ClientContext().getAccessTokenRequest().set("password", user.getPassword());
        return restTemplate.getAccessToken();
    }

    private String getClientIp(HttpServletRequest request) {
        return request.getRemoteAddr();
    }
}