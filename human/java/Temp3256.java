import org.springframework.security.core.GrantedAuthority;

public class Temp3256 {
    public static void main(String[] args) {
        for (Roles role : Roles.values()) {
            System.out.println("Role: " + role + ", Authority: " + role.getAuthority());
        }
    }

    public enum Roles implements GrantedAuthority {
        INVENTADMIN,
        INVENTUSER;

        @Override
        public String getAuthority() {
            return name();
        }
    }
}