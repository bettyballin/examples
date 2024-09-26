import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import your.package.name.Account; // Replace with your actual Account class package

@Component
public class AuthenticationService2 {
    public Account getAuthenticatedAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof Account) {
            return (Account) authentication.getPrincipal();
        }
        return null; // or throw an exception if the user is not authenticated
    }
}