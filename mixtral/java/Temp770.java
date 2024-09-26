import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class Temp770 {
    public static void main(String[] args) {
        Provider provider = new Provider();
        
        provider.setAuthoritiesPopulator((username, context) -> {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();

            // Populate your Granted Authorities here
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

            return grantedAuths;
        });
        
        // Example usage
        List<GrantedAuthority> authorities = provider.authoritiesPopulator.populateAuthorities("exampleUser", null);
        authorities.forEach(auth -> System.out.println(auth.getAuthority()));
    }
}

interface AuthoritiesPopulator {
    List<GrantedAuthority> populateAuthorities(String username, Object context);
}

class Provider {
    AuthoritiesPopulator authoritiesPopulator;

    public void setAuthoritiesPopulator(AuthoritiesPopulator authoritiesPopulator) {
        this.authoritiesPopulator = authoritiesPopulator;
    }
}