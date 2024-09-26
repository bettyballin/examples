import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class Temp1633 extends AbstractAuthenticationProcessingFilter {

    protected Temp1633() {
        super("/login");
    }

    public static void main(String[] args) {
        // Spring Boot application would be required to test this properly
        System.out.println("Run with a Spring Boot Application!");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        CustomAuthToken authToken = new CustomAuthToken(username, password);

        return this.getAuthenticationManager().authenticate(authToken);
    }
}

class CustomAuthToken implements Authentication {
    private final String username;
    private final String password;

    public CustomAuthToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getName() {
        return username;
    }

    @Override
    public String getCredentials() {
        return password;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    }

    @Override
    public java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
        return java.util.Collections.emptyList();
    }
}