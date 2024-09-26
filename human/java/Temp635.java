import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;

public class Temp635 {
    public static void main(String[] args) {
        Object principal = "user";
        Object credentials = "password";
        var authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));

        UsernamePasswordAuthenticationToken authenticationToken = 
            new UsernamePasswordAuthenticationToken(principal, credentials, authorities);

        System.out.println("Principal: " + authenticationToken.getPrincipal());
        System.out.println("Credentials: " + authenticationToken.getCredentials());
        System.out.println("Authorities: " + authenticationToken.getAuthorities());
    }
}