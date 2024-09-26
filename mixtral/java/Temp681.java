import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp681 {
    public static void main(String[] args) {
        // Example usage
    }

    public boolean hasWorkGroupPrivilege(UserDetails user, String requiredPrivilege) {
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            if ("ROLE_USER".equalsIgnoreCase(authority.getAuthority())) {
                // User is a member of at least one workgroup

                List<WorkGroup> workGroups = getUserWorkgroupsFromDatabase();

                for (WorkGroup wg : workGroups) {
                    if (wg.hasPrivilege(requiredPrivilege))
                        return true;
                }
            }
        }
        return false;
    }

    private List<WorkGroup> getUserWorkgroupsFromDatabase() {
        // Mock implementation, replace with actual database call
        return List.of(new WorkGroup());
    }

    class WorkGroup {
        public boolean hasPrivilege(String requiredPrivilege) {
            // Mock implementation, replace with actual privilege check
            return "somePrivilege".equals(requiredPrivilege);
        }
    }
}