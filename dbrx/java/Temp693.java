import java.util.ArrayList;
import java.util.List;

public class Temp693 {
    public static void main(String[] args) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        getUtenteConnesso().getAuthorities().forEach(authority -> authorities.add(authority));
    }

    public static User getUtenteConnesso() {
        // Mocking a user with authorities for demonstration purposes
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return new User("username", "password", authorities);
    }
}

interface GrantedAuthority {
    String getAuthority();
}

class SimpleGrantedAuthority implements GrantedAuthority {
    private String role;

    public SimpleGrantedAuthority(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}

class User {
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public User(String username, String password, List<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}