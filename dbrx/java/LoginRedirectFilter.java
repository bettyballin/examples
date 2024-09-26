import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginRedirectFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) { // user is not logged in
            String url = httpRequest.getRequestURL().toString();
            System.out.println(url);
            if(!httpRequest.getRequestURI().equals("/login")) {
                httpResponse.sendRedirect("/login");
            } else {
                chain.doFilter(request, response);  // let them proceed to /login
            }
        } else {
            if(httpRequest.getRequestURI().equals("/login")) {
                httpResponse.sendRedirect("/my/overview");   // redirect away from login page if already authenticated
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}