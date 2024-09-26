import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String userName = auth.getName().trim();
        String password = auth.getCredentials().toString().trim();
        String companyName = ((ExtraParam) auth.getDetails()).getCompanyName();

        // Implement your authentication logic here

        return null; // Return the appropriate Authentication object upon successful authentication
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // Return true if this AuthenticationProvider supports the indicated Authentication object.
        return true;
    }

    static class ExtraParam {
        private String companyName;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }
    }
}