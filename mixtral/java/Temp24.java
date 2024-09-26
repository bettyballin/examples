import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import java.util.Arrays;
import java.util.List;

public class Temp24 {
    public static void main(String[] args) {
        // Example usage
        Temp24 temp = new Temp24();
        // Populate with your own arguments as needed
        // temp.populateSwitchUserAuthorities(...);
    }

    public void populateSwitchUserAuthorities(
            SwitchUserGrantedAuthoritiesPopulator populator,
            String targetUsername
    ) {
        // Mocked currentRole and authorities for demonstration
        String currentRole = "DIVISION_SUPPORTER";
        List<GrantedAuthority> authorities = Arrays.asList(
                () -> "CLIENT" // Mocked authority
        );

        if (currentRole.equals("DIVISION_SUPPORTER")) {
            List<String> allowedTargetRoles = Arrays.asList("CLIENT");

            for (GrantedAuthority authority : authorities) {
                String roleName = authority.getAuthority();

                // Check if the target user has an authorized role
                if (!allowedTargetRoles.contains(roleName)) {
                    throw new AccessDeniedException("Access denied");
                }
            }
        }

        // Assuming super.populateSwitchUserAuthorities exists
        // super.populateSwitchUserAuthorities(populator, targetUsername);
    }

    // Mock interface for demonstration purposes
    interface SwitchUserGrantedAuthoritiesPopulator {
    }
}