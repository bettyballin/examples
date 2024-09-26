import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController12 {

    @GetMapping
    public ResponseEntity<?> doSomething(User user) {
        // Your logic here
        return ResponseEntity.ok().build();
    }
    
    // Assuming CurrentUser is a custom annotation that injects the current user
    // You would also need to define that annotation and its associated argument resolver
}