import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class Temp1140 {

    public static void main(String[] args) {
        // Main method for execution
    }

    public static class OTPAuthorizationFilter extends AbstractAuthenticationProcessingFilter {

        public OTPAuthorizationFilter() {
            super("/otp_login");
        }

        @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
            if (request.getParameter("username") == null || request.getParameter("password") == null || request.getParameter("otp") == null) {
                return null;
            }

            // return a new authentication token to be processed by the authentication provider
            return new OTPAuthorizationToken(request.getParameter("username"), request.getParameter("password"), request.getParameter("otp"));
        }
    }

    public static class OTPAuthorizationToken implements Authentication {
        
        private String username;
        private String password;
        private String otp;
        private boolean authenticated;

        public OTPAuthorizationToken(String username, String password, String otp) {
            this.username = username;
            this.password = password;
            this.otp = otp;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public Object getCredentials() {
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
            return authenticated;
        }

        @Override
        public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
            this.authenticated = isAuthenticated;
        }

        @Override
        public String getName() {
            return username;
        }
    }
}