import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomUrlNormalizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        int extensionIndex = path.lastIndexOf(".");
        if (extensionIndex != -1) {
            path = path.substring(0, extensionIndex);
        }

        // Update the request with normalized URL
        HttpServletRequestWrapper wrappedRequest = new HttpServletRequestWrapper(request) {
            @Override
            public String getServletPath() {
                return path;
            }
        };

        filterChain.doFilter(wrappedRequest, response);
    }
}