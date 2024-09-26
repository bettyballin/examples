import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : this.user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
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
        return this.user.isEnabled();
    }

    // User class for demonstration purposes
    public static class User {
        private String username;
        private String password;
        private boolean enabled;
        private List<Role> roles;

        public User(String username, String password, boolean enabled, List<Role> roles) {
            this.username = username;
            this.password = password;
            this.enabled = enabled;
            this.roles = roles;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public List<Role> getRoles() {
            return roles;
        }
    }

    // Role class for demonstration purposes
    public static class Role {
        private String role;

        public Role(String role) {
            this.role = role;
        }

        public String getRole() {
            return role;
        }
    }

    public static void main(String[] args) {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("ROLE_USER"));
        roles.add(new Role("ROLE_ADMIN"));

        User user = new User("john_doe", "password123", true, roles);
        CustomUserDetails userDetails = new CustomUserDetails(user);

        System.out.println("Username: " + userDetails.getUsername());
        System.out.println("Authorities: " + userDetails.getAuthorities());
        System.out.println("Account Non Expired: " + userDetails.isAccountNonExpired());
        System.out.println("Account Non Locked: " + userDetails.isAccountNonLocked());
        System.out.println("Credentials Non Expired: " + userDetails.isCredentialsNonExpired());
        System.out.println("Enabled: " + userDetails.isEnabled());
    }
}