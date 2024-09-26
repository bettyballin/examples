import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final UserService userService;

    @Autowired
    public CustomLoginSuccessHandler(UserService userService) {
        this.userService = userService;
    }

    public final static String TARGET_URL_SESSION_ATTR_NAME = "target-url";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        HttpSession session = request.getSession();

        AuthorityUser authorityUser = (AuthorityUser) authentication.getPrincipal();
        User u = userService.getById(authorityUser.getUserId());

        boolean changeRequiredDob = u.isChangeRequiredDob();
        boolean changeRequiredPwd = u.isChangeRequiredPwd();
        boolean changeRequiredTou = u.isChangeRequiredTou();

        if (changeRequiredDob || changeRequiredPwd || changeRequiredTou) {
            String targetUrl = determineTargetUrl(request, response);
            session.setAttribute(TARGET_URL_SESSION_ATTR_NAME, targetUrl);

            // Redirect to the action required screen
            getRedirectStrategy().sendRedirect(request, response, "/action-required");
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}