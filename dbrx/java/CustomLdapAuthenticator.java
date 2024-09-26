import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;
import java.util.ArrayList;

public class CustomLdapAuthenticator implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String cn) throws UsernameNotFoundException {
        // Dummy implementation for example purposes
        if (cn == null || cn.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        // Here you would normally authenticate against your LDAP server and fetch user details
        // For now, we will create a dummy user

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(cn, "password", authorities);
    }

    public static void main(String[] args) {
        CustomLdapAuthenticator authenticator = new CustomLdapAuthenticator();
        try {
            UserDetails user = authenticator.loadUserByUsername("testUser");
            System.out.println("User authenticated: " + user.getUsername());
        } catch (UsernameNotFoundException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}