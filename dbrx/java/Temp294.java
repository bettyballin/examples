import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreInvocationAuthorizationAdviceVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;

import java.util.ArrayList;
import java.util.List;

public class Temp294 {
    public static void main(String[] args) {
        Temp294 temp = new Temp294();
        Authentication authentication = getAuthentication();
        SecurityContextHolder.setContext(new SecurityContextImpl(authentication));
        temp.methodToProtect();
    }

    @PreAuthorize("hasRole('READ_ONLY')")
    public void methodToProtect() {
        // ...
    }

    private static Authentication getAuthentication() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_READ_ONLY"));
        return new UsernamePasswordAuthenticationToken("user", "password", authorities);
    }
}