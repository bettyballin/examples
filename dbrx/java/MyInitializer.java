import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;

import java.util.Set;
import java.util.Arrays;

@HandlesTypes({})
public class MyInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        // Register a servlet programmatically
        ServletRegistration.Dynamic reg = ctx.addServlet("mySecureServlet", SecureServlet.class);
        
        // Add security constraints to the registered servlet
        ServletSecurityElement securityElement = new ServletSecurityElement(
            new HttpConstraintElement(TransportGuarantee.CONFIDENTIAL, "SSORole")
        );

        reg.setServletSecurity(securityElement);
    }
}

// Example SecureServlet class
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecureServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello, Secure World!");
    }
}