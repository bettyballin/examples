import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.List;

public class SystemUserTask {

    public Authentication getSystemAuthentication() {
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_SYSTEM_USER");
        return new UsernamePasswordAuthenticationToken("system", null, authorities);
    }

    @Scheduled(fixedRate = 10000)
    public void runAsSystemUser() {
        Authentication originalAuth = SecurityContextHolder.getContext().getAuthentication();
        try {
            SecurityContextHolder.getContext().setAuthentication(getSystemAuthentication());
            // Call your method here
            getAllUsers();
        } finally {
            SecurityContextHolder.getContext().setAuthentication(originalAuth);
        }
    }

    private List<YourUserClass> getAllUsers() {
        // Your implementation here
        return null;
    }
}