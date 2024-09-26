import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSessionController extends SessionController {
    @Autowired
    private AdminFacade adminFacade;

    @RequestMapping("/welcome/{a}")
    public String getActiveSessions(@PathVariable String a) {
        return adminFacade.getName(a);
    }
}

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
public class AdminFacade {

    public String getName(String name) {
        return "This is " + name;
    }

    public String getDetailsForAdmin(String param) {
        return "admin details";
    }
}

class SessionController {
    // Assuming this is a placeholder for the actual SessionController
}