import javax.servlet.Filter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Order(SecurityProperties.DEFAULT_FILTER_ORDER + 1)
@Component
public class AfterSecurityFilter implements Filter {

    @Override
    public void doFilter(javax.servlet.ServletRequest request,
                         javax.servlet.ServletResponse response,
                         javax.servlet.FilterChain chain)
            throws java.io.IOException, javax.servlet.ServletException {
        // your filter implementation goes here
        chain.doFilter(request, response);
    }

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws javax.servlet.ServletException {
        // filter initialization code
    }

    @Override
    public void destroy() {
        // filter destruction code
    }
}