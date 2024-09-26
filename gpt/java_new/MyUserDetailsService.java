import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load the user from your data source
        // For example purposes, let's assume we have a method that gets user roles
        List<String> userRolesFromDataSource = getUserRolesFromDataSource(username);
        // And a method that gets the user's password
        String password = getUserPasswordFromDataSource(username);

        List<GrantedAuthority> grantedAuthorities = mapUserAuthorities(userRolesFromDataSource);
        return new User(username, password, grantedAuthorities);
    }

    private List<GrantedAuthority> mapUserAuthorities(List<String> roles) {
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    // Mock method to get user roles, replace with actual data source logic
    private List<String> getUserRolesFromDataSource(String username) {
        // Replace with actual logic to retrieve roles
        return List.of("ROLE_USER", "ROLE_ADMIN");
    }

    // Mock method to get user's password, replace with actual data source logic
    private String getUserPasswordFromDataSource(String username) {
        // Replace with actual logic to retrieve password
        return "password";
    }
}