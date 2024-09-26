import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;

public class VaadinSpringSecurity implements SecurityContext {

    private UserDetailsService userDetailsService;

    public VaadinSpringSecurity(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public void authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = (String) authentication.getCredentials();

        UserDetails user = userDetailsService.loadUserByUsername(username);

        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Invalid credentials") {
            };
        }

        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities()));
    }

    @Override
    public void setAuthentication(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public void clearContext() {
        SecurityContextHolder.clearContext();
    }

    public static void main(String[] args) {
        // Example usage:
        UserDetailsService userDetailsService = new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                // Implement your own user details service
                return null;
            }
        };

        VaadinSpringSecurity security = new VaadinSpringSecurity(userDetailsService);

        Authentication authentication = new UsernamePasswordAuthenticationToken("username", "password");

        try {
            security.authenticate(authentication);
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}