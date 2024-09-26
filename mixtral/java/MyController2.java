import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/example")
public class MyController {

    private final SecurityService securityService;

    @Autowired
    public MyController(SecurityService securityService) {
        this.securityService = securityService;
    }

    private List<String> permsIWantToReference = Arrays.asList("super", "long", "list");

    public List<String> getPerms() {
        return this.permsIWantToReference;
    }

    @PreAuthorize("@securityService.myCustomMethod(principal, #this.getPerms())")
    @GetMapping
    public ResponseEntity<?> doSomethingTopSecret() {
        // Your logic here
        return ResponseEntity.ok("Top secret action performed");
    }
}

@Service
class SecurityService {

    public boolean myCustomMethod(Object principal, List<String> perms) {
        // Your custom security logic here
        return true; // For demonstration purposes, always return true
    }
}