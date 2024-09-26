import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationService4 {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void updateUserAndAuthentication(String username, HttpServletRequest request) {
        // Update user in the database
        // updateUserService.updateUser(username, request); // Assuming this method exists elsewhere

        // Reload the updated user details
        UserDetails updatedUserDetails = userDetailsService.loadUserByUsername(username);

        // Create a new authentication token
        Authentication newAuth = new UsernamePasswordAuthenticationToken(
                updatedUserDetails, null, updatedUserDetails.getAuthorities());

        // Set the new authentication token
        SecurityContextHolder.getContext().setAuthentication(newAuth);
    }
}