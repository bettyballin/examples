import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

public class MyController7 {

    public List<String> perms_I_want_to_reference = Arrays.asList("super", "long", "list");

    @PreAuthorize("@securityService.MyCustomMethod(principal, #this.perms_I_want_to_reference)")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> doSomethingTopSecret() {
        // Your code here
        return ResponseEntity.ok().build();
    }
}