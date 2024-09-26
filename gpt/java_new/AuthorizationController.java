import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.ResponseEntity;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

@RestController
public class AuthorizationController {

    @RequestMapping(value = "/getAuthorization", method = RequestMethod.GET)
    public ResponseEntity<?> getAuthorization() {
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        // You would continue to implement your DTO and return logic here.
        // Assuming you have a DTO like UserRoleDTO and you want to return it.
        // return ResponseEntity.ok(new UserRoleDTO(authorities));
        return ResponseEntity.ok(authorities); // Placeholder return
    }
}