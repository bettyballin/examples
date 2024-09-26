import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Collection;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Temp836 {

    @RequestMapping(value = "/myPanel", method = RequestMethod.GET)
    public String myPanel(Model model, Principal principal) {
        if (principal != null && ((UserDetails) principal).getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            // do something for admin user here...
        }
        return "my_panel";
    }

    public static void main(String[] args) {
        // Spring application context initialization code here, if needed.
    }
}