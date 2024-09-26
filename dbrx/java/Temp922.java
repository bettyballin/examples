import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Temp922 implements javax.servlet.Filter {

    private static final String secretKey = "yourSecretKey"; // Replace with your actual secret key

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String token = httpRequest.getHeader("Authorization");

        if (token != null && !token.isEmpty() && token.startsWith("Bearer ")) {
            String jwtToken = token.substring(7);
            try {
                Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(jwtToken);
                chain.doFilter(request, response); // JWT is valid
            } catch (JwtException e) {
                throw new ServletException("Invalid or expired JWT", e);
            }
        } else {
            chain.doFilter(request, response); // No token provided
        }
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }

    public static void main(String[] args) {
        // This main method is just a placeholder and won't be used in a real web application scenario.
        System.out.println("This is a servlet filter and should be configured in a web application.");
    }
}