import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class YourClass11 {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    public void authenticate(Studio studio, Collection<? extends GrantedAuthority> authorities) {
        Authentication auth = new UsernamePasswordAuthenticationToken(studio.getUsername(), studio.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public void authenticateWithManager(Studio studio) {
        Authentication authRequest = new UsernamePasswordAuthenticationToken(studio.getUsername(), studio.getPassword());
        Authentication authResult = authenticationManager.authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(authResult);
    }

    // Assuming Studio is a custom class that you have elsewhere in your codebase
    class Studio {
        private String username;
        private String password;
        // Getters and setters for username and password
    }
}