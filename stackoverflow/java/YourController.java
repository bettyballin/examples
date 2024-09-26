import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YourController {

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @RequestMapping(value="/doblahblah")
    public String doBlahBlah(){
        methodOnlyAdminCanExecute();
        methodOnlyUserCanExecute();
        return "Blah executed";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value="/douserstuff")
    public String doUserStuff(){
        methodOnlyUserCanExecute();
        return "User stuff executed";
    }
    
    private void methodOnlyAdminCanExecute() {
        // admin-only logic
    }
    
    private void methodOnlyUserCanExecute() {
        // user logic
    }
}