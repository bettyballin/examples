import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/example")
public class MyController {

    @Autowired
    private SecurityService securityService;

    @Value("#{permissionList}")
    public List<String> perms_I_want_to_reference;

    public MyController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @PreAuthorize("@securityService.myCustomMethod(principal, #perms_I_want_to_reference)")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> doSomethingTopSecret() {
        return ResponseEntity.ok("Top Secret Content");
    }
}

@Service
class SecurityService {
    public boolean myCustomMethod(Object principal, List<String> perms_I_want_to_reference) {
        // Implement your custom security logic here
        return true; // For simplicity, always returning true
    }
}