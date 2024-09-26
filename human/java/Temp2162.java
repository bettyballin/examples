import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Temp2162 {
    private List<String> perms_I_want_to_reference = Arrays.asList("super", "long", "list");

    @PreAuthorize("@securityService.MyCustomMethod(principal, @temp2162.perms_I_want_to_reference)")
    @RequestMapping(method = RequestMethod.GET, value = "/secret")
    public ResponseEntity<?> doSomethingTopSecret() {
        return ResponseEntity.ok("Top Secret");
    }

    public List<String> getPerms_I_want_to_reference() {
        return perms_I_want_to_reference;
    }
}