import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

public class Main43 {
    public static void main(String[] args) {
        RoleHierarchyImpl r = new RoleHierarchyImpl();
        String hierarchy = "ROLE_ADMIN > ROLE_STAFF and ROLE_STAFF > ROLE_USER and " +
                           "ROLE_DEVELOPER > ROLE_USER and ROLE_USER > ROLE_GUEST";
        r.setHierarchy(hierarchy);
    }
}