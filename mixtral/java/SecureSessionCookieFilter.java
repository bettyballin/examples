import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecureSessionCookieFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;

        if ("https".equalsIgnoreCase(httpReq.getScheme())) {
            // HTTPS
            ((HttpServletResponse) response).setHeader("Set-Cookie", "JSESSIONID=" +
                    request.getSession().getId() + ";Secure");
        } else {
            // HTTP
            ((HttpServletResponse) response).setHeader("Set-Cookie", "JSESSIONID=" +
                    request.getSession().getId());
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}