import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CorsWebFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class OrderedCorsFilter implements Filter, Ordered {

    private final CorsWebFilter corsFilter;

    public OrderedCorsFilter(CorsWebFilter corsFilter) {
        this.corsFilter = corsFilter;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        corsFilter.doFilter(request, response, chain);
        
        // Add any additional logic here if needed.
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialize the filter if needed.
    }

    @Override
    public void destroy() {
        // Clean up resources if needed.
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}