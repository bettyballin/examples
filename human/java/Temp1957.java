import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Temp1957 {

    @RequestMapping(value = "/customlogin", method = RequestMethod.GET)
    public ModelAndView login(ModelMap model,
                              @RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        System.out.println("\n\t -------------");
        ModelAndView modelAndView = new ModelAndView("login");

        if (error != null) {
            modelAndView.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            modelAndView.addObject("msg", "You've been logged out successfully.");
        }
        return modelAndView;
    }
    
    public static void main(String[] args) {
        // You can add code here to start your Spring application context if needed
    }
}