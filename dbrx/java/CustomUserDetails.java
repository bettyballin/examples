import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String email;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, int id, String name, String email) {
        super(username, password, true, true, true, true, authorities);
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}