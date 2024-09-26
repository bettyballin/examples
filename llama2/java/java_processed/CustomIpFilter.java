import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

@WebFilter
public class CustomIpFilter implements Filter {

    private Set<String> whitelist = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialize the white list
        String whitelistParam = filterConfig.getInitParameter("whitelist");
        if (whitelistParam != null) {
            String[] ips = whitelistParam.split(",");
            for (String ip : ips) {
                whitelist.add(ip.trim());
            }
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Get the remote address of the client
        String remoteAddr = request.getRemoteAddr();

        if (whitelist.contains(remoteAddr)) {
            chain.doFilter(request, response);
        } else {
            response.getWriter().println("Unknown IP address: " + remoteAddr);
            response.setStatus(403); // Forbidden
        }
    }

    @Override
    public void destroy() {
        // Cleanup code if necessary
    }
}