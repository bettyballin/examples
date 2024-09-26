import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.ArrayList;
import java.util.List;

class CustomMethodDetails {
    private String methodName;

    public CustomMethodDetails(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }
}

public class CustomUserDetailsService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {
    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
        String username = (String) token.getPrincipal();
        Object details = token.getDetails();

        // Extract the method name from the details object.
        if (details instanceof CustomMethodDetails) {
            CustomMethodDetails customMethodDetails = (CustomMethodDetails) details;
            String methodName = customMethodDetails.getMethodName();

            // Perform your query based on username and methodName here.
            // For simplicity, we'll just create a user with a single authority.
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            return new User(username, "", authorities);
        }

        throw new UsernameNotFoundException("Cannot find user");
    }

    public static void main(String[] args) {
        CustomUserDetailsService service = new CustomUserDetailsService();
        CustomMethodDetails details = new CustomMethodDetails("someMethod");
        PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken("user", null, null);
        token.setDetails(details);

        try {
            UserDetails userDetails = service.loadUserDetails(token);
            System.out.println("User found: " + userDetails.getUsername());
        } catch (UsernameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}