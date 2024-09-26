import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

// Assuming the existence of TokenRepository and User classes
class TokenRepository {
    boolean existsByTokenValue(String tokenString) {
        // Implement token existence check logic
        return false;
    }

    java.util.Optional<Token> findTokenByTokenValue(String tokenString) {
        // Implement token retrieval logic
        return java.util.Optional.empty();
    }
}

class Token {
    User getUser() {
        // Implement user retrieval logic
        return new User();
    }
}

class User {
    java.util.Collection getAuthorities() {
        // Implement authorities retrieval logic
        return java.util.Collections.emptyList();
    }
}

public class Temp1377 extends OncePerRequestFilter {

    private TokenRepository tokenRepository = new TokenRepository();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String tokenString = request.getHeader("token");

        if (tokenString == null || !tokenRepository.existsByTokenValue(tokenString)) {
            // user is not authenticated or invalid token
            SecurityContextHolder.clearContext();
            chain.doFilter(request, response);
            return;
        }

        Token token = tokenRepository.findTokenByTokenValue(tokenString)
                .orElseThrow(() -> new RuntimeException("Invalid or expired token"));

        User user = token.getUser();

        if (user != null) {
            Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            System.out.println("=====doFilterInternal()==== authenticated user");
        }

        chain.doFilter(request, response);
    }

    public static void main(String[] args) {
        // This main method is just a placeholder and does not execute the filter
        System.out.println("Temp1377 class executed.");
    }
}