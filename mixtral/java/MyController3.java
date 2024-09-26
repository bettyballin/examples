import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/admin")
    @ResponseBody
    public String adminPage() {
        return "Admin Page";
    }

}