import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, HttpServletResponse response) {
        // Perform authentication logic here
        
        HttpSession session = request.getSession();
        
        if (passwordHasExpired()) {  // Implement your own password expiration check
            session.setAttribute("password_expired", true);
        } else {
            session.removeAttribute("password_expired");
        }
        
        return "login"; // Return to some view name or perform another action
    }

    private boolean passwordHasExpired() {
        // Implement your password expiration logic here
        return false;
    }
}