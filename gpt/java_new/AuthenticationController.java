import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;

public class AuthenticationController {

    private static final String LOGIN_PAGE = "login";

    @RequestMapping(value="/failed", method = RequestMethod.GET)
    public String showLoginFailurePage(Model model, HttpServletRequest request) {
        String authExClass = "";
        HttpSession session = request.getSession(false); // false -> do not create a new session if one does not exist
        if (session != null) {
            AuthenticationException authEx = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            
            if (authEx != null) {
                authExClass = authEx.getClass().getSimpleName();
                session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION); // remove the exception to prevent re-display
            }
        }
        model.addAttribute("authExClass", authExClass);
        return LOGIN_PAGE;
    }
}