import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp1958 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1958.class, args);
    }
}

@RestController
class MyController {
    @GetMapping("/participant/login")
    public ModelAndView loginPage(HttpServletRequest request,
                                  @RequestParam(value = "error", required = false) String error,
                                  @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView mav = new ModelAndView("login");

        Object exitMsgObj = request.getSession().getAttribute("EXIT_MSG");

        if (exitMsgObj != null && !"".equalsIgnoreCase((String) exitMsgObj)) {
            mav.addObject("info", "My generic logout message: " + (String) exitMsgObj);

            // Clear the session attribute
            request.getSession().removeAttribute("EXIT_MSG");
        }

        return mav;
    }
}