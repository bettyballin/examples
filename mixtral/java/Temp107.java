import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
public class Temp107 {

    public static void main(String[] args) {
        // Spring Boot Application would typically be started here
    }

    @PreAuthorize("hasRole('ROLE_A')")
    @RequestMapping(value = "/roleA/{uid}", method = RequestMethod.GET)
    public ResponseEntity<String> getSomethingForRoleA(@PathVariable("uid") String uid, Authentication auth) {
        // Returns something for users having ROLE_A
        return new ResponseEntity<>("Response for ROLE_A", HttpStatus.OK);
    }

    @PreAuthorize("#oauth2.clientHasRole('ROLE_B') or hasRole('ROLE_B')")
    @RequestMapping(value = "/roleB/{uid}", method = RequestMethod.GET)
    public ResponseEntity<String> getSomethingForRoleB(@PathVariable("uid") String uid, Authentication auth) {
        // Returns something different for users having ROLE_B
        return new ResponseEntity<>("Response for ROLE_B", HttpStatus.OK);
    }
}