import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class CustomAuthToken implements Authentication {
    private String subDomain;

    public CustomAuthToken(String subDomain) {
        this.subDomain = subDomain;
    }

    public String getSubDomain() {
        return subDomain;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    }

    public static void main(String[] args) {
        CustomAuthToken customAuthToken = new CustomAuthToken("exampleSubDomain");
        SecurityContextHolder.getContext().setAuthentication(customAuthToken);

        CustomAuthToken auth = (CustomAuthToken) SecurityContextHolder.getContext().getAuthentication();
        String subdomain = auth.getSubDomain();
        System.out.println("Subdomain: " + subdomain);
    }
}