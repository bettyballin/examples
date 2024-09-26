import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private OAuthClientConfig oAuthClientConfig;

    @Autowired
    private UserCredentialService userCredentialService;

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/user")
    public ResponseEntity<OAuth2AccessToken> createUserCredential(@RequestBody UserCredential user) {
        user.validate();
        userCredentialService.checkAndSaveUser(user, getClientIp(request));

        OAuth2RestOperations restTemplate = oAuthClientConfig.restTemplate();
        restTemplate.getOAuth2ClientContext().getAccessTokenRequest().set("username", user.getLogin());
        restTemplate.getOAuth2ClientContext().getAccessTokenRequest().set("password", user.getPassword());
        OAuth2AccessToken token = restTemplate.getAccessToken();
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    private String getClientIp(HttpServletRequest request) {
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
}

class OAuthClientConfig {
    public OAuth2RestOperations restTemplate() {
        // Implementation here
        return null;
    }
}

class UserCredential {
    public void validate() {
        // Implementation here
    }

    public String getLogin() {
        // Implementation here
        return null;
    }

    public String getPassword() {
        // Implementation here
        return null;
    }
}

class UserCredentialService {
    public void checkAndSaveUser(UserCredential user, String clientIp) {
        // Implementation here
    }
}