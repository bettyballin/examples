import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

public class User7 {
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public User7(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    // Assume getters and setters are here
}

class Main {
    public static void main(String[] args) {
        // Assuming user1 is a previously defined User7 object
        // Assuming encodedPwd is a String containing the encoded password
        // Assuming authorities is a collection of GrantedAuthority objects
        User7 user = new User7(user1.getUser7name(), encodedPwd, authorities);
    }
}