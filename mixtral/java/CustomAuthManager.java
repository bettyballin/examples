import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

public final class CustomAuthManager implements AuthenticationManager {

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        if (authentication instanceof PreAuthenticatedAuthenticationToken && !request.getHeader("authorization").isEmpty()) {
            String token = authentication.getCredentials().toString();

            // Perform your custom validation here

            return new UsernamePasswordAuthenticationToken(
                    "custom_user",
                    null,
                    Collections.emptyList());
        }

        throw new BadCredentialsException("Invalid token");
    }

    public static void main(String[] args) {
        // You can add some test cases here to verify the functionality
        System.out.println("CustomAuthManager is ready for authentication.");
    }
}