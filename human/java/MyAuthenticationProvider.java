import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationProvider;

import java.io.Serializable;

public class MyAuthenticationProvider implements AuthenticationProvider, Serializable {

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Implement your authentication logic here
        return null;
    }

    public static void main(String[] args) {
        // Example usage
        MyAuthenticationProvider provider = new MyAuthenticationProvider();
        System.out.println(provider.supports(UsernamePasswordAuthenticationToken.class));
    }
}