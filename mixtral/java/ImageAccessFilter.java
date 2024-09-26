import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/images/*")
public class ImageAccessFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;

        // Get the requested image filename from URL
        String pathInfo = httpReq.getPathInfo();

        if (pathInfo == null || !pathInfo.startsWith("/")) {
            ((HttpServletResponse) response).sendError(403);
            return;
        }

        // Remove leading slash
        pathInfo = pathInfo.substring(1);

        String username = httpReq.getRemoteUser();

        if (username == null || !isImageOwner(pathInfo, username)) {
            ((HttpServletResponse) response).sendError(403);
            return;
        }

        // Forward request to image servlet
        chain.doFilter(request, response);
    }

    private boolean isImageOwner(String filename, String userName) {
        /*
         * Implement this method by querying your database table
         * and checking if the given username matches with
         * creator of image having 'filename'
         */
        return true; // Placeholder for actual database query
    }

    @Override
    public void destroy() {
        // Cleanup code
    }
}