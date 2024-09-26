import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

public class Example {
    private boolean isAdmin() {
        Authentication currentAuthObj = SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) currentAuthObj.getAuthorities();
        for (GrantedAuthority auth : authorities) {
            if ("ROLE_ADMIN".equals(auth.getAuthority())) {
                return true;
            }
        }
        return false;
    }

    public void addEditPermissions(ModelAndView modelAndView, boolean currentUserIsAuthor) {
        modelAndView.addObject("canEditPost", currentUserIsAuthor || isAdmin());
    }
}