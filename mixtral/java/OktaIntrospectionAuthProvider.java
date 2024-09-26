import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class OktaIntrospectionAuthProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException, UsernameNotFoundException {

        // Call
        return null; // Dummy return to make it compile
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true; // Dummy return to make it compile
    }

    public static void main(String[] args) {
        System.out.println("OktaIntrospectionAuthProvider is set up!");
    }
}