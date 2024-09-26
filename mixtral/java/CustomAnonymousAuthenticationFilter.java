import org.springframework.security.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;

public class CustomAnonymousAuthenticationFilter extends AnonymousAuthenticationFilter {

    public CustomAnonymousAuthenticationFilter(String key) {
        super(key, "anonymousUser", Arrays.asList(new SimpleGrantedAuthority("ROLE_ANONYMOUS")));
    }

    @Override
    public void setDetails(Object details) {
        // Custom implementation if needed
        super.setDetails(details);
    }

    public static void main(String[] args) {
        CustomAnonymousAuthenticationFilter filter = new CustomAnonymousAuthenticationFilter("mySecretKey");
        System.out.println(filter.getPrincipal()); // Output: anonymousUser
        System.out.println(filter.getAuthorities()); // Output: [ROLE_ANONYMOUS]
    }
}