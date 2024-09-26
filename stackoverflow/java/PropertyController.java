import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

    private final CustomRedisTokenStore mCustomRedisTokenStore;

    @Autowired
    public PropertyController(@Qualifier("customRedisTokenStore") CustomRedisTokenStore customRedisTokenStore) {
        this.mCustomRedisTokenStore = customRedisTokenStore;
    }

    @PutMapping(value = "change/property")
    public void changeProperty(Long propertyid) {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setCurrentPropertyid(propertyid);
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        OAuth2AccessToken accessToken = mCustomRedisTokenStore.getAccessToken(oAuth2Authentication);
        mCustomRedisTokenStore.storeAccessToken(accessToken, oAuth2Authentication);
    }
}