import org.springframework.stereotype.Service;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SecuredService {

    @Secured("ROLE_ADMIN")
    public void methodA() {
        // code
    }
}

@Controller
public class MyController {

    @Autowired
    private SecuredService securedService;
}