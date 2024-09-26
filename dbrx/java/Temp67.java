import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.authentication.ProviderManager;

import java.util.ArrayList;
import java.util.List;

public class Temp67 {
    private AuthenticationManager authenticationManager;

    public Temp67() {
        // Initialize your authenticationManager here
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        this.authenticationManager = new ProviderManager(List.of()); // Dummy initialization
    }

    public static void main(String[] args) {
        String principal = "yourUsername";
        String password = "yourPassword";
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        Temp67 temp67 = new Temp67();
        
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                principal, 
                password, 
                authorities
        );

        Authentication authenticationResult = temp67.authenticationManager.authenticate(authRequest);
    }
}