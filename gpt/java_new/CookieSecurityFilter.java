import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class CookieSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        // Initialization code...
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        chain.doFilter(request, response);

        if (response instanceof HttpServletResponse) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            Collection<String> headers = httpResponse.getHeaders("Set-Cookie");
            boolean isSecure = request.isSecure();
            List<String> newHeaders = new ArrayList<>();

            for (String header : headers) {
                if (isSecure && !header.toLowerCase().contains("secure")) {
                    newHeaders.add(header + "; Secure");
                } else {
                    newHeaders.add(header);
                }
            }

            httpResponse.setHeader("Set-Cookie", String.join(",", newHeaders));
        }
    }

    @Override
    public void destroy() {
        // Cleanup code...
    }
}