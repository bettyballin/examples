import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.access.prepost.PreAuthorize;

public class YourServiceClass1 {

    @Scheduled(fixedRate = 10000)
    public void indexUsers() {
        Authentication authentication = new UsernamePasswordAuthenticationToken("system", null, AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
        try {
            getAllUsers(); // Call your secured method
        } finally {
            SecurityContextHolder.clearContext(); // Ensure to clear the context after use
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void getAllUsers() {
        // Your method implementation
    }
}