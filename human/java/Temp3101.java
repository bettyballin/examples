import org.keycloak.KeycloakPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp3101 {
    public static void main(String[] args) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof KeycloakPrincipal) {
            KeycloakPrincipal principal = (KeycloakPrincipal) authentication.getPrincipal();
            System.out.println(principal.getName());
        } else {
            System.out.println("Principal is not an instance of KeycloakPrincipal");
        }
    }
}