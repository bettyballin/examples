import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebListener
public class AppConfigListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        HttpConstraintElement httpConstraintElement = new HttpConstraintElement(ServletSecurity.TransportGuarantee.CONFIDENTIAL, new String[]{"SSORole"});
        HttpMethodConstraintElement getMethod = new HttpMethodConstraintElement("GET", httpConstraintElement);
        HttpMethodConstraintElement postMethod = new HttpMethodConstraintElement("POST", httpConstraintElement);

        ServletSecurityElement securityElement = new ServletSecurityElement(httpConstraintElement, getMethod, postMethod);
        // Implementation to add the security element to the context is omitted as the provided snippet is incomplete and cannot be corrected without further context.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Code to handle context destruction if necessary
    }
}