import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Map;

public class YourOwnAuthentication extends AbstractAuthenticationToken {
    private final CustomObject principal;
    private final String bearerString;

    public YourOwnAuthentication(String bearerString, Map<String, Object> claims, Converter<Map<String, Object>, Collection<? extends GrantedAuthority>> authoritiesConverter) {
        super(authoritiesConverter.convert(claims));
        this.bearerString = bearerString;
        this.principal = new CustomObject(claims); // CustomObject's implementation is assumed
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return bearerString;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    // Assuming CustomObject class exists and has a constructor accepting Map<String, Object>
    public static class CustomObject {
        CustomObject(Map<String, Object> claims) {
            // Implementation depends on the CustomObject class details
        }
    }
}