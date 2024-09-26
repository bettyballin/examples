import java.util.ArrayList;
import java.util.List;

interface GrantedAuthority {
    String getAuthority();
}

class UserDetails {
    private List<GrantedAuthority> authorities;
    
    public UserDetails() {
        authorities = new ArrayList<>();
        // Example authorities
        authorities.add(() -> "ROLE_USER");
        authorities.add(() -> "ROLE_ADMIN");
    }
    
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}

class SecurityContextHolder {
    private static UserDetails principal = new UserDetails();
    
    public static UserDetails getPrincipal() {
        return principal;
    }
}

public class Temp44 {
    public static void main(String[] args) {
        UserDetails userDetails = SecurityContextHolder.getPrincipal();
        userDetails.getAuthorities().forEach(authority -> System.out.println(authority.getAuthority()));
    }
}