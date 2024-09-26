import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.security.AccessDeniedException;
import java.util.List;

@RestController
public class YourController8 {

    @GetMapping("/getFindByPersonId/{perId}")
    public List getFindBySkhsIdCombo(@PathVariable Long perId) {
        Long currentUserId = getCurrentUserId(); // Assuming implementation is available
        if (!perId.equals(currentUserId)) {
            throw new AccessDeniedException("You do not have permission to access this data");
        }
        
        // Assuming comboVahedAmooz is defined and accessible within the scope
        // return comboVahedAmooz;
        // Stub return, replace with actual data retrieval
        return List.of(); // Replace with actual data retrieval logic
    }
    
    private Long getCurrentUserId() {
        // Implement logic to retrieve the current user's ID
        return null; // Replace with actual implementation
    }
}