import javax.servlet.*;
import javax.servlet.http.*;

public class CustomFilter1 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        chain.doFilter(request, new HttpServletResponseWrapper((HttpServletResponse) response) {
            @Override
            public void setHeader(String name, String value) {
                if (!"ETag".equalsIgnoreCase(name)) {
                    super.setHeader(name, value);
                }
            }
        });
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code...
    }

    @Override
    public void destroy() {
        // Cleanup code...
    }
}