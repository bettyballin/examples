import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Value("${AUTH_USERNAME}")
    private String username;

    @Value("${AUTH_PASSWORD}")
    private String password;

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public MyAuthenticationProvider(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String inputUsername = authentication.getName();
        String inputPassword = (String) authentication.getCredentials();

        UserDetails userDetails;
        try {
            userDetails = userDetailsService.loadUserByUsername(inputUsername);
        } catch (UsernameNotFoundException e) {
            throw new AuthenticationException("Username not found") {
                @Override
                public String getMessage() {
                    return super.getMessage();
                }
            };
        }

        if (inputUsername.equals(username) && passwordEncoder.matches(inputPassword, password)) {
            return new UsernamePasswordAuthenticationToken(userDetails, inputPassword, userDetails.getAuthorities());
        } else {
            throw new AuthenticationException("Invalid credentials") {
                @Override
                public String getMessage() {
                    return super.getMessage();
                }
            };
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}