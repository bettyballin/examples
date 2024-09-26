import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {
    private static final String TOKEN_PARAM = "token";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
            throws ServletException, IOException {
        if (request.getParameter(TOKEN_PARAM) != null && isValidToken(request)) {
            try {
                authenticateUser(request);
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
        chain.doFilter(request, response);
    }

    private boolean isValidToken(HttpServletRequest request) {
        // Implement your token validation logic here
        String token = request.getParameter(TOKEN_PARAM);
        return "abcd".equals(token);  // Replace this with actual validation logic
    }

    private void authenticateUser(HttpServletRequest request) throws Exception {
        UsernamePasswordAuthenticationToken authRequest =
            new UsernamePasswordAuthenticationToken("foo", "bar");
        authRequest.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        AuthenticationManager authenticationManager = getApplicationContext().getBean(AuthenticationManager.class);
        Authentication authResult = authenticationManager.authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(authResult);
    }

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
        getFilterConfig().getServletContext().log("Init TokenAuthenticationFilter");
    }
}