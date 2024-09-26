import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Temp860 {
    public static void main(String[] args) {
        // Spring Boot application entry point if needed
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_GUEST')")
    public ModelAndView view() {
        // ... your code here
        return new ModelAndView("view");
    }
}