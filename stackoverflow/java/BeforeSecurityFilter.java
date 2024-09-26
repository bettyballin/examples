import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import java.io.IOException;

@Order(SecurityProperties.DEFAULT_FILTER_ORDER - 1)
@Component
public class BeforeSecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // initialization code
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // filter logic here
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // cleanup code
    }
}