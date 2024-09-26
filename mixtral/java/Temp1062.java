import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp1062 {
    public static void main(String[] args) {
        // Spring Boot application main method should be here
    }

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal MyUserDetails myUserDetails) {
        // Now you can access the authenticated principal
        return "User details accessed";
    }

    @PostAuthorize("hasRole('ROLE_ADMIN') or hasPermission(returnObject, 'read')")
    public String user(@AuthenticationPrincipal MyCustomPrincipal myCustomPrincipal) {
        // Now you can access the authenticated principal
        return "Custom principal accessed";
    }
}

// Dummy classes to make the code compile
class MyUserDetails {}
class MyCustomPrincipal {}