import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/guest")
public class GuestController {

    @GetMapping({"/login", "/login?"})
    public String login(HttpServletRequest request, Model model) {
        if (request.getParameter("error") != null && !"".equalsIgnoreCase(request.getParameter("error"))) {
            // Show error message
            model.addAttribute("message", "Invalid username or password!");

            return "login";
        }

        return "login";
    }
}