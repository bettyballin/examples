import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class AuthenticationService3 {

    private AuthenticationManager authenticationManager;

    // Assume there's a constructor or setter for authenticationManager

    public void autoLogin(String username, String password) {
        User userDetails = new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                userDetails, password, userDetails.getAuthorities());

        // Authenticate the user
        UsernamePasswordAuthenticationToken authenticatedToken =
                (UsernamePasswordAuthenticationToken) authenticationManager.authenticate(authRequest);

        SecurityContextHolder.getContext().setAuthentication(authenticatedToken);
    }

    // Assume there's a main method or some entry point that calls autoLogin
}