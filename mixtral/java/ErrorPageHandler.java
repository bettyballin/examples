import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorPageHandler {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            // Set an anonymous authentication object
            AnonymousAuthenticationToken token = new AnonymousAuthenticationToken(
                "anonymous", "guest", AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"));

            SecurityContextHolder.getContext().setAuthentication(token);
        }

        return "/error";
    }
}