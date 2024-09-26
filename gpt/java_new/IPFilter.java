import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class IPFilter implements Filter {
    private static final ThreadLocal<String> clientIpAddress = new ThreadLocal<>();

    public static String getClientIpAddress() {
        return clientIpAddress.get();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            String ip = request.getRemoteAddr();
            clientIpAddress.set(ip);
        }
        try {
            chain.doFilter(request, response);
        } finally {
            clientIpAddress.remove();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Implementation here...
    }

    @Override
    public void destroy() {
        // Implementation here...
    }
}