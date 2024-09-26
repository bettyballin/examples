import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController1 {

   @RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
   public String failed(HttpServletRequest request, ModelMap model) {
       HttpSession session = request.getSession(false);
       if (session != null) {
           session.invalidate();
       }
       SecurityContextHolder.clearContext();
       model.addAttribute("error", "Login failed. Please try again.");
       return "login";
   }
}