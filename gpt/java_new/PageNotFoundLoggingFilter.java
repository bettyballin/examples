import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.HandlerMapping;
import java.io.IOException;

public class PageNotFoundLoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE) == null) {
            String ip = request.getRemoteAddr();
            String uri = httpRequest.getRequestURI();
            System.out.println("WARN - No mapping found for HTTP request with URI [" + uri + "] from IP [" + ip + "]");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Cleanup code if needed
    }
}