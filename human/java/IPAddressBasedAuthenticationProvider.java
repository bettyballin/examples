import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Service 
public class IPAddressBasedAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String ipAddress = request.getRemoteAddr();
        
        // Example of valid IP address array
        String[] validIPAddresses = {"127.0.0.1", "192.168.1.1"};
        
        boolean isValidIP = false;
        for (String validIP : validIPAddresses) {
            if (validIP.equals(ipAddress)) {
                isValidIP = true;
                break;
            }
        }

        if (!isValidIP) {
            throw new AuthenticationException("Invalid IP Address") {};
        }

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Authenticate the user using userDetailsService
        UserDetails user;
        try {
            user = userDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            throw new AuthenticationException("Invalid username or password") {};
        }

        if (!password.equals(user.getPassword())) {
            throw new AuthenticationException("Invalid username or password") {};
        }

        return new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                username, password, new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                org.springframework.security.authentication.UsernamePasswordAuthenticationToken.class);
    }
}