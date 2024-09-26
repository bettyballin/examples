import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Temp1243 {
    public static void main(String[] args) {
        // Main method content if needed
    }

    // In IndustryController
    @RequestMapping("/viewAddIndustrYForm")
    @PreAuthorize("hasAnyRole('ROLE_RECRUITER')")
    public ModelAndView viewAddIndustryForm() {
        // Add your implementation here
        return new ModelAndView("addIndustryForm");
    }

    // In LoginController
    @RequestMapping("/userpage")
    @PreAuthorize("isAuthenticated() and hasAnyRole('ROLE_RECRUITER', 'OTHER_ROLES')")
    public ModelAndView userPage() {
        // Add your implementation here
        return new ModelAndView("userPage");
    }
}