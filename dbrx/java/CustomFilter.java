import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("customFilter")
public class CustomFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String uri = (String) request.getAttribute(HandlerMappingBEST_MATCHING_PATTERN_ATTRIBUTE);
        if (uri != null && !uri.isEmpty() && uri.contains("#")) {
            int index = uri.indexOf('#');
            uri = uri.substring(0, index);
            request.setAttribute(WebUtils.FORWARD_REQUEST_URI_ATTRIBUTE, uri);
        }
        chain.doFilter(request, response);
    }
}