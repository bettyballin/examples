import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/doStuff")
    public String doStuff() {
        // ...
        return "stuffDone";
    }
}