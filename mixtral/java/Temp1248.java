import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Temp1248 {
    public static void main(String[] args) {
        // This is a Spring Boot application; the entry point is not required for this example.
    }

    // Only users with ADMIN role will be able to access this endpoint
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin() {
        // ...
        return new ModelAndView("admin");
    }

    // Users with GUEST or ADMIN roles can view data
    @PreAuthorize("hasAnyRole('GUEST', 'ADMIN')")
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view() {
        // ...
        return new ModelAndView("view");
    }
}