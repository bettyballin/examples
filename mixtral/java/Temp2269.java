import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class Temp2269 {
    public static void main(String[] args) {
        String username = "user"; // Add a sample username
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
        
        // Placeholder for authProvider.authenticate method
        // Authentication result = authProvider.authenticate(authentication);
        
        System.out.println("Authentication: " + authentication);
    }
}