import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class Temp1476 {
    public static void main(String[] args) {
        String userEmail = "user@example.com";
        String base64Password = "password";

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        UserDetails user = User.withUsername(userEmail)
                .password(base64Password)
                .authorities(grantedAuthorities)
                .build();

        // Just to verify the user object is created
        System.out.println("User: " + user.getUsername() + ", Password: [" + user.getPassword() + "]");
    }
}