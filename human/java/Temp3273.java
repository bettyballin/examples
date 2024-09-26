import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class Temp3273 {
    public static void main(String[] args) {
        Temp3273 temp = new Temp3273();
        Collection<? extends GrantedAuthority> authorities = temp.getAuthorities();
        authorities.forEach(auth -> System.out.println(auth.getAuthority()));
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        User user = new User("ROLE_USER"); // Assuming a User class with a getRole method
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }
}

class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}