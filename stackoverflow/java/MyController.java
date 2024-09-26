// The provided snippet is a reference to a class in the Spring Security framework and not a code snippet to be compiled.
// There is nothing to refactor here as it stands. If you're looking to use the class, you might do so in a Spring
// Security configuration class or a controller, but without additional context, no refactoring can be applied.

// If you were to use it in a Spring MVC controller, it might look something like this:

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
public class MyController {

    @GetMapping("/user")
    @ResponseBody
    public UserDetails getCurrentUser(@AuthenticationPrincipal UserDetails user) {
        return user;
    }
}