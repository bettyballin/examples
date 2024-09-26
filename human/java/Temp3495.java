import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/get-url-here")
    public String main(@AuthenticationPrincipal User user) {
        if (user.getRole().equals("ROLE_ADMIN")) {
            // set values for admin
        } else {
            // set for user
        }
        return "view-or-response-body";
    }
}

class User {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


For this code to work, you will also need to have a Spring Boot application setup with the necessary dependencies in your `pom.xml` or `build.gradle` files.