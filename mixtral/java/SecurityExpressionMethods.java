import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.HttpServlet3RequestFactory;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionRoot;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;

import javax.servlet.http.HttpServletRequest;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends GlobalMethodSecurityConfiguration {

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new CustomMethodSecurityExpressionHandler();
    }

    public static class CustomMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {
        @Override
        protected MethodSecurityExpressionRoot createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
            CustomMethodSecurityExpressionRoot root = new CustomMethodSecurityExpressionRoot(authentication);
            root.setRequestFactory((HttpServlet3RequestFactory) invocation.getArguments()[0]);
            return root;
        }
    }

    public static class CustomMethodSecurityExpressionRoot extends MethodSecurityExpressionRoot {

        private HttpServlet3RequestFactory requestFactory;

        public CustomMethodSecurityExpressionRoot(Authentication authentication) {
            super(authentication);
        }

        public void setRequestFactory(HttpServlet3RequestFactory requestFactory) {
            this.requestFactory = requestFactory;
        }

        public boolean hasSecureConnection(boolean isSecured) {
            return requestFactory.getHttpServletRequest().isSecure() == isSecured;
        }
    }
}

public class MyController {
    
    @PreAuthorize("hasRole('ROLE_USER') and hasSecureConnection(false)")
    public String nonSecurePage(HttpServlet3RequestFactory requestFactory) {
        // Your code here
        return "Accessed non-secure page";
    }
}

public class CustomHttpServlet3RequestFactory implements HttpServlet3RequestFactory {
    
    private final HttpServletRequest request;

    public CustomHttpServlet3RequestFactory(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public HttpServletRequest getHttpServletRequest() {
        return request;
    }

    // Other methods required by the interface
}