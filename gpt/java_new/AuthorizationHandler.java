import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthorizationHandler {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Autowired
    public AuthorizationHandler(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    public Map<String, Object> loginUser(String userName, String password) {
        Map<String, Object> map = new HashMap<>();
        try {
            // Retrieve user details
            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
            // Create authentication token
            UsernamePasswordAuthenticationToken authReq =
                    new UsernamePasswordAuthenticationToken(userDetails.getUsername(), password, userDetails.getAuthorities());
            // Authenticate the user
            Authentication auth = authenticationManager.authenticate(authReq);
            // Set authentication to security context
            if (auth.isAuthenticated()) {
                map.put("status", "success");
            } else {
                map.put("status", "failure");
            }
        } catch (Exception e) {
            map.put("status", "exception");
            map.put("message", e.getMessage());
        }
        return map;
    }
}