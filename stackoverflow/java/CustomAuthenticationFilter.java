import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomAuthenticationFilter extends FormAuthenticationFilter {
    private Map<String, String> loginUrlByUserAgent = new HashMap<>();

    public void setLoginUrls(final Map<String, String> loginUrlByUserAgent) {
        this.loginUrlByUserAgent = loginUrlByUserAgent;
    }

    @Override
    protected void redirectToLogin(final ServletRequest request, final ServletResponse response) throws IOException {
        final String loginUrl = getLoginUrl(request);
        WebUtils.issueRedirect(request, response, loginUrl);
    }

    private String getLoginUrl(final ServletRequest request) {
        final String userAgent = getUserAgent(request);
        return userAgent != null && loginUrlByUserAgent.containsKey(userAgent) ?
                loginUrlByUserAgent.get(userAgent) :
                super.getLoginUrl();
    }

    private String getUserAgent(final ServletRequest request) {
        return WebUtils.toHttp(request).getHeader("User-Agent");
    }
}