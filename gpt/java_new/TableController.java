import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@RestController
public class TableController {

    @ManyToOne
    @JoinColumn(name = "created_by_user_id")
    private User createdBy;

    private TableService tableService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteTable(@PathVariable Long id, Authentication authentication) {
        Table table = tableService.findOne(id);
        User loggedInUser = (User) authentication.getPrincipal(); // Assuming User is your UserDetails implementation

        if (table != null && table.getCreatedBy().equals(loggedInUser)) {
            tableService.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(403).build();
        }
    }
    
    // Additional methods and class components go here

    // Assume User, Table, and TableService classes are defined elsewhere
}