import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CustomSessionConfig implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        String domain = getDomainFromRequest(se.getSession().getServletContext());

        if (isSecureDomain(domain)) {
            ((HttpSession) se.getSession()).setSecure(true);
        } else {
            ((HttpSession) se.getSession()).setSecure(false);
        }
    }

    private boolean isSecureDomain(String domain) {
        // Implement your custom logic here to determine whether the given
        // domain should have a secure session cookie or not.
        
        return true;  // Return 'true' for HTTPS domains and 'false' otherwise.
    } 

    private String getDomainFromRequest(ServletContext context) {
        HttpServletRequest request = (HttpServletRequest) context.getAttribute("com.sun.faces.request");

        if (request != null) {
            return request.getServerName();
        }

        // If the load balancer doesn't forward SSL information you might need
        // to extract it from a custom header or other means.
        return null;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Session destruction logic goes here
    }
}