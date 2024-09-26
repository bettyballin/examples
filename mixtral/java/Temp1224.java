import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class Temp1224 {

    public static void main(String[] args) {
        // Entry point for standalone Java application, not used in Spring MVC applications
    }

    @RequestMapping("/login")
    public @ResponseBody ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            HttpServletResponse response,
            HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("login");
        if (error != null) {
            modelAndView.addObject("error", "Invalid username or password.");
        }
        if (logout != null) {
            modelAndView.addObject("msg", "You've been logged out successfully.");
        }
        return modelAndView;
    }
}