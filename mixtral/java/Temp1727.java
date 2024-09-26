import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

// Define your permitted URI patterns and AuthSessionToken class
public class Temp1727 extends UsernamePasswordAuthenticationFilter {
    private final String[] permittedUriPatterns = {"/public/**"};
    private final UserDetailsService userDetailsService;

    public Temp1727(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        // Check if this is a permitAll URI
        boolean shouldAuthenticate = !Arrays.stream(permittedUriPatterns)
                .anyMatch(pattern -> new AntPathMatcher().matchStart(pattern, request.getServletPath()));

        Authentication auth;

        if (shouldAuthenticate) {
            // If it's not a permitAll URI and the header is missing or invalid
            String sessionId = request.getHeader("sessionId");

            if (StringUtils.isEmpty(sessionId)) {
                throw new ServletException("Missing header 'sessionId'.");
            }

            UserDetails userDetails = userDetailsService.loadUserByUsername(sessionId);
            auth = new AuthSessionToken(userDetails);
        } else {
            // If it is a permitAll URI create an anonymous authentication
            auth = new AnonymousAuthenticationToken("key", "anonymousUser", AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"));
        }

        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);
    }

    public static void main(String[] args) {
        // This main method can be used to run the filter in a Spring Boot application context
        System.out.println("Spring Security Filter Example");
    }
}

class AuthSessionToken extends org.springframework.security.authentication.UsernamePasswordAuthenticationToken {
    public AuthSessionToken(Object principal) {
        super(principal, null);
    }
}