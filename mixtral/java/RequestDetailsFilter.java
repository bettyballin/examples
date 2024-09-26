import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestDetailsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Store the requested URI and method in a thread-local variable
        RequestAttributesHolder.setCurrentUriAndMethod(request);

        try {
            filterChain.doFilter(request, response);

        } finally {

            // Clear the stored values after request processing
            RequestAttributesHolder.clear();

        }
    }
}

class RequestAttributesHolder {
    private static final ThreadLocal<String> currentUri = new ThreadLocal<>();
    private static final ThreadLocal<String> currentMethod = new ThreadLocal<>();

    public static void setCurrentUriAndMethod(HttpServletRequest request) {
        currentUri.set(request.getRequestURI());
        currentMethod.set(request.getMethod());
    }

    public static String getCurrentUri() {
        return currentUri.get();
    }

    public static String getCurrentMethod() {
        return currentMethod.get();
    }

    public static void clear() {
        currentUri.remove();
        currentMethod.remove();
    }
}