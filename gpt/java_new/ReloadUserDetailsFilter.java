import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.*;
import java.io.IOException;

public class ReloadUserDetailsFilter implements Filter {

    private UserDetailsService userDetailsService;

    public ReloadUserDetailsFilter(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();

        if (currentAuth != null && currentAuth.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) currentAuth.getPrincipal();
            UserDetails refreshedUser = userDetailsService.loadUserByUsername(userDetails.getUsername());
            Authentication newAuth = new UsernamePasswordAuthenticationToken(
                    refreshedUser, currentAuth.getCredentials(), refreshedUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(newAuth);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}