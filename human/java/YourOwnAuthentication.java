import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collection;
import java.util.Map;

public class YourOwnAuthentication extends AbstractAuthenticationToken {
    private final CustomObject principal;
    private final String bearerString;

    public YourOwnAuthentication(String bearerString, Map<String, Object> claims, Converter<Map<String, Object>, Collection<? extends GrantedAuthority>> authoritiesConverter) {
        super(authoritiesConverter.convert(claims));
        super.setAuthenticated(true);
        this.bearerString = bearerString;
        this.principal = new CustomObject(claims); // I connot figure out how you'll actually build that
    }

    @Override
    public String getCredentials() {
        return bearerString;
    }

    @Override
    public CustomObject getPrincipal() {
        return principal;
    }
    
    public String getBearerString() {
        return bearerString;
    }
}

class CustomObject {
    private final Map<String, Object> claims;

    public CustomObject(Map<String, Object> claims) {
        this.claims = claims;
    }

    public Map<String, Object> getClaims() {
        return claims;
    }

    // Add other methods as needed
}