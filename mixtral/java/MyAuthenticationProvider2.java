import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class MyAuthenticationProvider implements AuthenticationProvider {

    private static final ThreadLocal<String> REQUEST_SPECIFIC = new ThreadLocal<>();

    public static void setRequestSpecificValue(String value) {
        REQUEST_SPECIFIC.set(value);
    }

    public static void clearRequestSpecificValue() {
        REQUEST_SPECIFIC.remove();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String specificValue = REQUEST_SPECIFIC.get();

        // Use the value as needed

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // Implement logic to determine if the authentication type is supported
        return true;
    }
}