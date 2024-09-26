import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController2 {

    @RequestMapping("/login/failure")
    public String loginFailure(HttpServletRequest request, Model model) {
        // Assuming the username is retrieved from the request for demonstration
        String username = request.getParameter("username");
        model.addAttribute("error", "Login failed for user " + username);
        return "login";
    }
}