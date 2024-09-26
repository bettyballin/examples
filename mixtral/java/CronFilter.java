import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CronFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {}

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;

        String cronHeaderValue = httpReq.getHeader("X-AppEngine-Cron");

        if ("true".equals(cronHeaderValue)) {
            chain.doFilter(httpReq, response);
        } else {
            ((HttpServletResponse) response).sendError(
                    HttpServletResponse.SC_FORBIDDEN);
        }
    }
}