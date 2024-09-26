import org.springframework.security.core.GrantedAuthority;
import java.util.ArrayList;
import java.util.List;

public class TenantAwareGrantedAuthority implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private final String role;
    private final String ownership;

    public TenantAwareGrantedAuthority(String role, String ownership) {
        this.role = role;
        this.ownership = ownership;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    public String getOwnership() {
        return ownership;
    }

    // Include additional methods if necessary, such as equals, hashCode, and toString
}

// Assuming the below is another part of the code
class SomeOtherClass {
    private List<GrantedAuthority> getGrantedAuthoritiesForStore(){
        List<GrantedAuthority> authorities = new ArrayList<>();
        // Assuming you have a way to get the ownership, for example "sec"
        // and roles, you would do something like this:
        // String ownership = "someOwnership";
        // String role = "someRole";
        // authorities.add(new TenantAwareGrantedAuthority(role, ownership));
        return authorities;
    }
}