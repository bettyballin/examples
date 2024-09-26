import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.core.oidc.StandardClaimNames;

public class Temp3639 {
    public static void main(String[] args) {
        // This is a mock example, in real use, you would get the SecurityContext from an actual security context setup.
        // For example's sake, let's assume a Jwt object with claims is already in the security context.
        Jwt mockJwt = Jwt.withTokenValue("token")
                .header("alg", "none")
                .claim(StandardClaimNames.PREFERRED_USERNAME, "user123")
                .build();

        // Mocking SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(new JwtAuthentication(mockJwt));

        // Extracting the preferred username
        String preferredUsername = ((Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .getClaims().get(StandardClaimNames.PREFERRED_USERNAME).toString();
        System.out.println("Preferred Username: " + preferredUsername);
    }
}

// Mock JwtAuthentication class for the sake of the example
class JwtAuthentication implements org.springframework.security.core.Authentication {
    private final Jwt jwt;

    public JwtAuthentication(Jwt jwt) {
        this.jwt = jwt;
    }

    @Override
    public Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public Object getCredentials() {
        return jwt.getTokenValue();
    }

    @Override
    public Object getDetails() {
        return jwt;
    }

    @Override
    public Object getPrincipal() {
        return jwt;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        // Do nothing
    }

    @Override
    public String getName() {
        return jwt.getClaimAsString(StandardClaimNames.PREFERRED_USERNAME);
    }
}