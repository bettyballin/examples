import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Temp2058 {
    public static void main(String[] args) {
        System.out.println("Main method executed.");
    }

    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (authentication.getCredentials() == null || !authentication.getCredentials().equals(userDetails.getPassword())) {
            throw new AuthenticationException("Authentication failed!") {};
        }
    }
}