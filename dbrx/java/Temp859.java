import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Temp859 {
    public static void main(String[] args) {
        // Spring Boot application would be needed to run this as is
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView admin() {
        // Dummy implementation
        return new ModelAndView("admin");
    }
}