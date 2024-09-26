import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import javax.servlet.http.HttpServletRequest;

public class Temp1805 {

    private UserDetailsServiceImpl userDetailsServiceImpl;

    public static void main(String[] args) {
        // Main method content goes here if needed
    }

    public Authentication authenticateUserAndSetSession(String username, HttpServletRequest request) {

        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());

        return authentication;
    }

    // Setter for userDetailsServiceImpl to inject the dependency
    public void setUserDetailsServiceImpl(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }
}

// Mock implementation of UserDetailsServiceImpl for demonstration
class UserDetailsServiceImpl {
    public UserDetails loadUserByUsername(String username) {
        // Implement this method to load user details based on the username
        return null; // Replace with actual user details
    }
}