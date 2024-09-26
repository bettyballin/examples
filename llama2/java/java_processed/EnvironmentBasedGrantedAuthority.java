import java.util.Collections;
import java.util.List;

public class EnvironmentBasedGrantedAuthority implements org.springframework.security.core.GrantedAuthority {
    private String readRole;

    public EnvironmentBasedGrantedAuthority(String readRole) {
        this.readRole = readRole;
    }

    @Override
    public String getAuthority() {
        return readRole;
    }

    public List<String> getAuthorities() {
        return Collections.singletonList(readRole);
    }

    public static void main(String[] args) {
        EnvironmentBasedGrantedAuthority authority = new EnvironmentBasedGrantedAuthority("ROLE_USER");
        System.out.println("Authority: " + authority.getAuthority());
        System.out.println("Authorities: " + authority.getAuthorities());
    }
}