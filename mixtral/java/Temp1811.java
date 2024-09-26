import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public class Temp1811 implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet((Collection<? extends GrantedAuthority>) authentication.getAuthorities());

        if (roles.contains("ROLE_ADMIN")) {
            RedirectView redirectView = new RedirectView("/admin/", true);
            new ModelAndView(redirectView).render(null, request, response);
        } else {
            // handle other roles
            response.sendRedirect("/home");
        }
    }

    public static void main(String[] args) {
        // This method is intentionally left empty. The main functionality is handled in onAuthenticationSuccess.
    }
}