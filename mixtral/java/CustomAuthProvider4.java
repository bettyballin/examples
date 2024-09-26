import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    private JwtService jwtService; // Assuming a JwtService to handle JWT validation and extraction

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String jwtToken = (String) authentication.getCredentials();
        UserDetails userDetails = jwtService.validateAndExtractUserDetails(jwtToken); // Custom method to validate and extract user details from JWT

        Collection<? extends GrantedAuthority> grantedAuthorities = userDetails.getAuthorities();
        return new UsernamePasswordAuthenticationToken(userDetails, null, grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}