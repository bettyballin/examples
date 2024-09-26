import java.util.Collections;
import java.util.Set;

public class Temp1191 {
    public static void main(String[] args) {
        // Example usage of the getAuthorities method
        Temp1191 temp = new Temp1191();
        System.out.println(temp.getAuthorities());
    }

    public Set<GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + this.getRole()));
    }

    private String getRole() {
        // Example role, replace with actual logic to retrieve the role
        return "USER";
    }
}

interface GrantedAuthority {
    String getAuthority();
}

class SimpleGrantedAuthority implements GrantedAuthority {
    private final String role;

    public SimpleGrantedAuthority(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public String toString() {
        return "SimpleGrantedAuthority{" + "role='" + role + '\'' + '}';
    }
}