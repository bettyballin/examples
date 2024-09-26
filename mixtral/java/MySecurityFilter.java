import java.io.IOException;
import java.security.Principal;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.microprofile.jwt.JsonWebToken;

@WebFilter("/*")
public class MySecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

    @Inject
    private SecurityContext securityContext;

    @Resource
    private EJBContext ejbContext;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;

        if ("GET".equalsIgnoreCase(httpReq.getMethod()) ||
                "POST".equalsIgnoreCase(httpReq.getMethod())) {

            // Check for SSORole
            boolean isSSOUser = securityContext.isCallerInRole("SSORole");

            if (!isSSOUser) {

                HttpServletResponse httpResp = (HttpServletResponse) response;

                String errorPage = "/error.html";

                RequestDispatcher dispatcher = request.getRequestDispatcher(errorPage);

                if (dispatcher != null) {

                    httpResp.setStatus(HttpServletResponse.SC_FORBIDDEN);

                    dispatcher.forward(request, response);

                    return;
                }

            }

            // Check for CLIENT-CERT

            Principal userPrincipal = httpReq.getUserPrincipal();

            if (userPrincipal == null) {

                HttpServletResponse httpResp = (HttpServletResponse) response;

                String errorPage = "/error.html";

                RequestDispatcher dispatcher = request.getRequestDispatcher(errorPage);

                if (dispatcher != null) {

                    httpResp.setStatus(HttpServletResponse.SC_FORBIDDEN);

                    dispatcher.forward(request, response);

                    return;
                }
            }
        }

        chain.doFilter(request, response);
    }
}