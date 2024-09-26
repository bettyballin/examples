import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class SecureFilter extends OncePerRequestFilter {
    private final boolean enableSecure;

    public SecureFilter(boolean enableSecure) {
        this.enableSecure = enableSecure;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        CookieHttpServletResponseWrapper wrappedResponse =
                new CookieHttpServletResponseWrapper(response, enableSecure);

        try {
            filterChain.doFilter(request, wrappedResponse);
        } finally {
            // Ensure that the original response is used for further processing.
            request.setAttribute("org.springframework.web.servlet.DispatcherServlet.OUTPUT_FLASH_MAP_REQUEST_ATTRIBUTE", null);
        }
    }
}

class CookieHttpServletResponseWrapper extends HttpServletResponseWrapper {
    private final boolean enableSecure;

    public CookieHttpServletResponseWrapper(HttpServletResponse response, boolean enableSecure) {
        super(response);
        this.enableSecure = enableSecure;
    }

    @Override
    public void addCookie(Cookie cookie) {
        if (enableSecure) {
            cookie.setSecure(true);
        }
        super.addCookie(cookie);
    }
}