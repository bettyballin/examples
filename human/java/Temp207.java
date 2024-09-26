import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class Temp207 {

    public static void main(String[] args) {
        AuthenticationProvider provider = new MyAuthenticationProvider();
        Authentication authentication = new UsernamePasswordAuthenticationToken("user", "password");
        
        try {
            Authentication result = provider.authenticate(authentication);
            System.out.println("Authentication successful: " + result.isAuthenticated());
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }

    static class MyAuthenticationProvider implements AuthenticationProvider {
        private UserDetailsService userDetailsService = createUserDetailsService();

        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            String username = authentication.getName();
            String password = authentication.getCredentials().toString();

            UserDetails userDetails;
            try {
                userDetails = userDetailsService.loadUserByUsername(username);
            } catch (UsernameNotFoundException e) {
                throw new AuthenticationException("User not found") {};
            }

            if (password.equals(userDetails.getPassword())) {
                return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
            } else {
                throw new AuthenticationException("Authentication failed") {};
            }
        }

        @Override
        public boolean supports(Class<?> authentication) {
            return authentication.equals(UsernamePasswordAuthenticationToken.class);
        }

        private UserDetailsService createUserDetailsService() {
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            manager.createUser(User.withUsername("user").password("password").roles("USER").build());
            return manager;
        }
    }
}