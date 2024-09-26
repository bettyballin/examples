import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import javax.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;

public class MyController13 {

    @PreAuthorize("@fromPropertyRoleSecurityCheck.verifyRoles()")
    public ResponseEntity<MyDto> findById(@PathVariable @Positive Integer id) {
        // ...
        return ResponseEntity.ok(new MyDto());
    }
    
    // Dummy MyDto class for the sake of example
    class MyDto {
        // ...
    }
    
    // Dummy FromPropertyRoleSecurityCheck class for the sake of example
    class FromPropertyRoleSecurityCheck {
        public boolean verifyRoles() {
            // ...
            return true;
        }
    }
}