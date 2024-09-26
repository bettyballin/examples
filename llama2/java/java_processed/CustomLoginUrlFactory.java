import org.apache.shiro.authc.credential.Credential;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

public class CustomLoginUrlFactory implements LoginUrlFactory {
    private static final String MOBILE_USER_AGENT = "Mobile";

    @Override
    public String createLoginUrl(credential credential, AuthorizationInfo authorizationInfo) {
        String userAgent = WebUtils.getUserAgent(WebUtils.getRequest());

        if (userAgent.contains(MOBILE_USER_AGENT)) {
            return "/mobile/login";
        } else {
            return "/standard/login";
        }
    }
}
interface LoginUrlFactory {
    String createLoginUrl(Credential credential, AuthorizationInfo authorizationInfo);
}