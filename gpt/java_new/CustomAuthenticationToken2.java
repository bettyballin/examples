import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.filter.OncePerRequestFilter;
import java.util.Collection;

public class CustomAuthenticationToken2 extends AbstractAuthenticationToken {
    private final CustomObject customObject;

    public CustomAuthenticationToken2(CustomObject customObject, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.customObject = customObject;
        setAuthenticated(true); // Removed 'super' as it is not necessary and might cause confusion
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public Object getPrincipal() {
        return customObject;
    }
}

// Assuming CustomObject class is defined somewhere
class CustomObject {
    // CustomObject fields and methods
}