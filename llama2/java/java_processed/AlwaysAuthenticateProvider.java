import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import java.util.Arrays;

public class AlwaysAuthenticateProvider extends DaoAuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Create a fully populated Authentication object
        UserDetails user = User.withUsername("username")
                .password("password")
                .authorities(Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();

        // Return the authenticated Authentication object
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    public static void main(String[] args) {
        // Example usage
        AuthenticationManager authenticationManager = new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                AlwaysAuthenticateProvider provider = new AlwaysAuthenticateProvider();
                return provider.authenticate(authentication);
            }
        };

        Authentication auth = new UsernamePasswordAuthenticationToken("username", "password");
        Authentication result = authenticationManager.authenticate(auth);

        if (result.isAuthenticated()) {
            System.out.println("Authentication successful: " + result.getName());
        } else {
            System.out.println("Authentication failed");
        }
    }
}