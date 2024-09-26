import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;

public final class MethodSecurityExpressionRoot extends SecurityExpressionRoot {

    public MethodSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    // This method will be used for accessing the principal object
    public User getPrincipal() {
        return (User)((UsernamePasswordAuthenticationToken) this.getAuthentication()).getPrincipal();
    }

    public static void main(String[] args) {
        // Example usage
        User user = new User("username", "password", new ArrayList<>());
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        MethodSecurityExpressionRoot root = new MethodSecurityExpressionRoot(auth);

        User principal = root.getPrincipal();
        System.out.println("Principal: " + principal.getUsername());
    }
}