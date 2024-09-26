import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Temp2008 {

    public static void main(String[] args) {
        // Main method is not required for Spring Boot applications
    }

    @RequestMapping(value = "/lihdOfruesKeerkuess", method = RequestMethod.POST)
    public ModelAndView lidhOfruesKerrkues(@ModelAttribute("merrPersiperkeekuess") Kerkuess k,
                                           Ofruess ofruess,
                                           Authentication authResult) {
        if (authResult != null && authResult.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return new ModelAndView("redirect:/adminHome");
        }

        return new ModelAndView("redirect:/ofrojNdihmeView/getKeerkuessAktiv");
    }
}

// Assuming Kerkuess and Ofruess are defined somewhere in your project
class Kerkuess {
    // Class definition
}

class Ofruess {
    // Class definition
}