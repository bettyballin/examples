import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;

public class MyFilter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        SecurityContextHolderAwareRequestWrapper requestWrapper =
                new SecurityContextHolderAwareRequestWrapper(httpRequest, null);
        chain.doFilter(requestWrapper, res);
    }
}