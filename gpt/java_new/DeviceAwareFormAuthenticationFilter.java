import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class DeviceAwareFormAuthenticationFilter extends FormAuthenticationFilter {

    private String mobileLoginUrl;
    private String desktopLoginUrl;

    public String getMobileLoginUrl() {
        return mobileLoginUrl;
    }

    public void setMobileLoginUrl(String mobileLoginUrl) {
        this.mobileLoginUrl = mobileLoginUrl;
    }

    public String getDesktopLoginUrl() {
        return desktopLoginUrl;
    }

    public void setDesktopLoginUrl(String desktopLoginUrl) {
        this.desktopLoginUrl = desktopLoginUrl;
    }

    @Override
    protected String getLoginUrl() {
        HttpServletRequest req = (HttpServletRequest) this.getSubject(ServletRequest.class.cast(this.getSubject().getServletRequest())).getServletRequest();
        if (isMobileDevice(req)) {
            return getMobileLoginUrl();
        } else {
            return getDesktopLoginUrl();
        }
    }

    private boolean isMobileDevice(HttpServletRequest request) {
        // Implement device detection logic
        // Placeholder for actual mobile device check
        String userAgent = request.getHeader("User-Agent");
        return userAgent != null && userAgent.toLowerCase().contains("mobile");
    }
}