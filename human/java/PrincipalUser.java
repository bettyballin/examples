import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PrincipalUser implements UserDetails {
    private static final long serialVersionUID = 1L;

    // my personal User class
    private User user;

    public PrincipalUser(User user) {
        super();
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getPseudo();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Assuming a simple User class for demonstration purposes
    public static class User {
        private String password;
        private String pseudo;

        public User(String password, String pseudo) {
            this.password = password;
            this.pseudo = pseudo;
        }

        public String getPassword() {
            return password;
        }

        public String getPseudo() {
            return pseudo;
        }
    }

    // For testing purposes
    public static void main(String[] args) {
        User user = new User("password123", "username");
        PrincipalUser principalUser = new PrincipalUser(user);

        System.out.println("Username: " + principalUser.getUsername());
        System.out.println("Password: " + principalUser.getPassword());
        System.out.println("Authorities: " + principalUser.getAuthorities());
        System.out.println("Account Non Expired: " + principalUser.isAccountNonExpired());
        System.out.println("Account Non Locked: " + principalUser.isAccountNonLocked());
        System.out.println("Credentials Non Expired: " + principalUser.isCredentialsNonExpired());
        System.out.println("Enabled: " + principalUser.isEnabled());
    }
}