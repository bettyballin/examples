import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

public class TestSecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        SecurityContextHolderAwareRequestWrapper wrappedRequest = new SecurityContextHolderAwareRequestWrapper(request);

        // Set the principal in case it's needed
        Principal mockPrincipal = new Principal() {
            @Override
            public String getName() {
                return "testUser";
            }
        };

        if (mockPrincipal != null) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    mockPrincipal.getName(),
                    null,
                    AuthorityUtils.createAuthorityList("ROLE_USER")
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(wrappedRequest, response);
    }
}