import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

@WebFilter("/temp2031")
public class Temp2031 implements Filter {
    private static final Logger log = LoggerFactory.getLogger(Temp2031.class);
    private Set<String> whiteList;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        whiteList = new HashSet<>();
        // Add IP addresses to the whitelist
        whiteList.add("127.0.0.1");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String ipAddress = request.getRemoteAddr();

        if (!whiteList.contains(ipAddress)) {

            try {
                throw new UnknownHostException("Unknown IP address");

            } catch (UnknownHostException e) {

                log.error("Error: {}", e);

                // Set response status and message
                HttpServletResponse httpResp = (HttpServletResponse) response;

                httpResp.setStatus(HttpStatus.FORBIDDEN.value());

                PrintWriter writer = httpResp.getWriter();

                writer.write("Error: Unknown IP address");

            }

        } else {

            chain.doFilter(request, response);

        }
    }

    @Override
    public void destroy() {
        // Cleanup code if necessary
    }

    public static void main(String[] args) {
        System.out.println("Temp2031 filter is ready to use.");
    }
}