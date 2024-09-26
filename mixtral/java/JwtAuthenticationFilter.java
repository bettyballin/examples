import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Extract the token from header
        String jwtToken = getJWTFromHeader(request);

        if (StringUtils.hasText(jwtToken)) {
            try {
                Jws<Claims> claimsJws = Jwts.parser().setSigningKey("secret_key").parseClaimsJws(jwtToken);
                // Add your logic here to handle the parsed claims
            } catch (Exception e) {
                // Handle the exception appropriately
            }
        }

        filterChain.doFilter(request, response);
    }

    private String getJWTFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}