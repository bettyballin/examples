import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.switchuser.SwitchUserGrantedAuthority;

public class SecurityUtil2 {

    public static boolean isCurrentUserSwitched() {
        Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();
        if (currentAuth != null) {
            for (GrantedAuthority authority : currentAuth.getAuthorities()) {
                if (authority instanceof SwitchUserGrantedAuthority) {
                    return true;
                }
            }
        }
        return false;
    }
}