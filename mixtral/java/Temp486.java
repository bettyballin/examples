import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/tables")
public class Temp486 {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        // Spring Boot application should start here if you have a main class
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<TableDTO> delete(@PathVariable Long id) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User u = getUserByUsername(userDetails.getUsername());

        // Fetch table
        Table t = tableRepository.findById(id).orElse(null);

        if (t == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Check creator
        if (!u.equals(t.getCreator())) {
            throw new AccessDeniedException("You are not authorized to delete this table");
        }

        // Delete
        tableRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

// Assuming you have these classes/interfaces
interface TableRepository {
    Table findById(Long id);
    void deleteById(Long id);
}

interface UserRepository {
    User findByUsername(String username);
}

class TableDTO {
    // Your fields and methods here
}

class Table {
    private User creator;
    
    public User getCreator() {
        return creator;
    }
    
    // Other fields and methods
}

class User {
    // Your fields and methods here
}


To execute this code, you would need a Spring Boot application setup with the required dependencies and configurations, including `TableRepository`, `UserRepository`, `User`, `Table`, and `TableDTO` classes.