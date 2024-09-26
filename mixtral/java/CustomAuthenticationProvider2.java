import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String username = (String) authentication.getPrincipal();

        // Perform additional checks such as checking the user's IP address

        return new UsernamePasswordAuthenticationToken(
                username,
                null,
                AuthorityUtils.createAuthorityList("ROLE_USER")
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // This method is used to determine if this AuthenticationProvider
        // can support the given type of authentication token

        return UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication);
    }
}