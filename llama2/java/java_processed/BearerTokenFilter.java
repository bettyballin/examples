import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;

@Component
public class BearerTokenFilter extends OncePerRequestFilter {

    private final AuthenticationService authenticationService;

    public BearerTokenFilter(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
            throws ServletException, IOException {
        String bearerToken = request.getHeader("Authorization");

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            String token = bearerToken.substring(7);
            Authentication auth = authenticationService.authenticate(token);

            if (auth != null) {
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        chain.doFilter(request, response);
    }
}

interface AuthenticationService {
    Authentication authenticate(String token);
}

// Add a basic implementation for demonstration purposes
@Component
class DefaultAuthenticationService implements AuthenticationService {
    @Override
    public Authentication authenticate(String token) {
        // Replace this with actual authentication logic
        if (token.equals("mysecrettoken")) {
            return new PreAuthenticatedAuthenticationToken("myuser", token);
        }
        return null;
    }
}