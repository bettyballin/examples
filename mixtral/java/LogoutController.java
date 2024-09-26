import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping(value = "/customLogout", method = RequestMethod.GET)
    public String logOutUserAndRedirectToLoginPage(HttpServletRequest httpServletRequest, HttpSession session) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && !auth.getName().equalsIgnoreCase("anonymous")) {
            new SecurityContextLogoutHandler().logout(httpServletRequest, null, auth);
        }

        return "redirect:/login";
    }
}