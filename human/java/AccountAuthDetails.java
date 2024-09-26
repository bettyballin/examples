import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

class Account {
    private String username;
    private String password;
    private boolean isActive;

    public Account(String username, String password, boolean isActive) {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return isActive;
    }
}

class AccountAuthDetails extends Account implements UserDetails {

    public AccountAuthDetails(String username, String password, boolean isActive) {
        super(username, password, isActive);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the authorities granted to the user
        return null; // Placeholder for simplicity
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Indicate whether the account has expired
        return true; // Placeholder for simplicity
    }

    @Override
    public boolean isAccountNonLocked() {
        // Indicate whether the account is locked
        return true; // Placeholder for simplicity
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Indicate whether the user's credentials have expired
        return true; // Placeholder for simplicity
    }

    @Override
    public boolean isEnabled() {
        return super.isActive();
    }
}

public class Main {
    public static void main(String[] args) {
        AccountAuthDetails user = new AccountAuthDetails("user1", "password123", true);
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Is Active: " + user.isActive());
    }
}