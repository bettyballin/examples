import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LanguageUrlFilter extends FilterChainProxy {

    private final AntPathRequestMatcher languagePattern = new AntPathRequestMatcher("/?lang=([a-zA-Z]{2})");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // initialization logic if needed
    }

    @Override
    public void destroy() {
        // cleanup logic if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String langParam = httpRequest.getParameter("lang");
        if (langParam != null && languagePattern.matches(httpRequest)) {
            // Grant access without authentication
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        chain.doFilter(request, response);
    }
}