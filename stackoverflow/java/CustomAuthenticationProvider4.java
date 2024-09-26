import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider4 implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String userName = auth.getName().trim();
        String password = auth.getCredentials().toString().trim();
        String companyName = ((ExtraParam)auth.getDetails()).getCompanyName();

        // Rest of the authentication logic...

        return null; // You should return a fully authenticated object once the authentication process is complete
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // You should implement this method to specify which type of authentication the provider supports
        return false; // For example, return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    private static class ExtraParam {
        // Dummy implementation for ExtraParam class
        String getCompanyName() {
            return "ExampleCompany";
        }
    }
}