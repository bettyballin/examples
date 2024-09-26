import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

public class MobileDeviceFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        boolean isMobile = false;

        // Check if the user-agent string indicates a mobile device.
        String header = request.getHeader("User-Agent");

        if (header != null && (
                header.contains("Android") ||
                    header.contains("iPhone"))) {
            isMobile = true;
        }

        // Set a custom attribute in the request to indicate whether it's from mobile or not
        request.setAttribute("is_mobile", isMobile);

        chain.doFilter(request, response);
    }
}