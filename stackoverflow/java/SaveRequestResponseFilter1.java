import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveRequestResponseFilter1 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        RequestResponseHolder.setRequestResponse(req, resp);
        try {
            chain.doFilter(request, response);
        } finally {
            RequestResponseHolder.clear();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
        // ... implementation here
    }

    @Override
    public void destroy() {
        // ... implementation here
    }
}

class RequestResponseHolder {
    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();
    private static final ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<>();

    public static void setRequestResponse(HttpServletRequest request, HttpServletResponse response) {
        requestHolder.set(request);
        responseHolder.set(response);
    }

    public static void clear() {
        requestHolder.remove();
        responseHolder.remove();
    }
}