import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Controller
public class TokenController {

    private final TokenStore tokenStore;

    @Autowired
    public TokenController(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/revoke")
    public void revokeToken(@RequestParam String token) {
        tokenStore.removeRefreshToken(tokenStore.readRefreshToken(token));
    }
}