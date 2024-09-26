import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

   @PreAuthorize("hasRole('ROLE_ADMIN')")
   @RequestMapping("/admin")
   public String adminPage(Model model) {
       // ...
       return "admin";
   }
}