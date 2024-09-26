import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HstsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse)response;

        // Set the HSTS header
        httpResponse.setHeader("Strict-Transport-Security", "max-age=15768000");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}