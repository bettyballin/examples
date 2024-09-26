import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

public class YourController5 {

    @GetMapping
    public ResponseEntity<?> doSomething(@AuthenticationPrincipal(expression = "userService.getUser(#this)") User user) {
        // Your implementation
        return ResponseEntity.ok().build();
    }
    
    // Assuming User class and userService bean are defined elsewhere in your codebase
}