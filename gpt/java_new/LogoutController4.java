import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.core.context.SecurityContextHolder;

public class LogoutController4 {

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        
        // Get the referer URL and provide a fallback in case it's not found
        String refererUrl = request.getHeader("Referer");
        refererUrl = (refererUrl != null) ? refererUrl : "/homepage";
        
        // Redirect to the referer URL or fallback URL
        return "redirect:" + refererUrl;
    }
}