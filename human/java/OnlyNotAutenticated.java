import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class OnlyNotAuthenticated extends AccessControlFilter {

    private String welcomeurl = "";

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        return !subject.isAuthenticated(); // THE POINT
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        WebUtils.issueRedirect(request, response, welcomeurl);
        return false; //What to do if try to go to login -> go welcome page of auth users
    }

    public String getWelcomeurl() {
        return welcomeurl;
    }

    public void setWelcomeurl(String welcomeurl) {
        this.welcomeurl = welcomeurl;
    }

    public static void main(String[] args) {
        // Example usage
        OnlyNotAuthenticated filter = new OnlyNotAuthenticated();
        filter.setWelcomeurl("/welcome");

        // Add your test logic here
    }
}