import org.springframework.security.core.GrantedAuthority;

public final class CustomAuthoritiesConstants {
    public static final String SUPERVISED = "SUPERVISED";
}

public class CustomRole implements GrantedAuthority {

    private final String role;

    public CustomRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    public static void main(String[] args) {
        CustomRole customRole = new CustomRole(CustomAuthoritiesConstants.SUPERVISED);
        System.out.println("Role: " + customRole.getAuthority());
    }
}