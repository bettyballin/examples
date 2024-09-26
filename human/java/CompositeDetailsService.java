import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class CompositeDetailsService implements UserDetailsService {

    private final List<UserDetailsService> services;

    public CompositeDetailsService(List<UserDetailsService> services) {
        this.services = services;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for (UserDetailsService delegate : this.services) {
            try {
                return delegate.loadUserByUsername(username);
            } catch (UsernameNotFoundException ignore) {
            }
        }
        throw new UsernameNotFoundException("");
    }

    public static void main(String[] args) {
        // Example usage
        UserDetailsService userService1 = new MockUserDetailsService("user1");
        UserDetailsService userService2 = new MockUserDetailsService("user2");

        CompositeDetailsService compositeService = new CompositeDetailsService(List.of(userService1, userService2));

        try {
            UserDetails user = compositeService.loadUserByUsername("user1");
            System.out.println("User found: " + user.getUsername());
        } catch (UsernameNotFoundException e) {
            System.out.println("User not found");
        }
    }
}

class MockUserDetailsService implements UserDetailsService {

    private final String username;

    public MockUserDetailsService(String username) {
        this.username = username;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (this.username.equals(username)) {
            return new MockUserDetails(username);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

class MockUserDetails implements UserDetails {

    private final String username;

    public MockUserDetails(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public String getUsername() {
        return this.username;
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
}