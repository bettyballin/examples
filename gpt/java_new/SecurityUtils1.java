import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Set;
import java.util.stream.Collectors;

public class SecurityUtils1 {

    public static boolean loggedInUserHasAnyOfThesePermissions(String... permissions) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }
        
        Set<String> userAuthorities = authentication.getAuthorities().stream()
            .map(authority -> authority.getAuthority())
            .collect(Collectors.toSet());
        
        return userAuthorities.stream().anyMatch(userAuthority -> 
            java.util.Arrays.asList(permissions).contains(userAuthority)
        );
    }
}