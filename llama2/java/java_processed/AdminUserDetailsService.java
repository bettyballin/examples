import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.Collection;

public class AdminUserDetailsService extends CustomUserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // For demonstration, we are returning a hardcoded user with admin role
        if ("admin".equals(username)) {
            return User.withUsername("admin")
                    .password("{noop}password") // {noop} means no password encoder
                    .roles("ADMIN")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    public static void main(String[] args) {
        AdminUserDetailsService service = new AdminUserDetailsService();
        try {
            UserDetails admin = service.loadUserByUsername("admin");
            System.out.println("Admin username: " + admin.getUsername());
            System.out.println("Admin authorities: " + admin.getAuthorities());
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class CustomUserDetailsService {
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Placeholder for custom implementation
        return null;
    }
}