import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp2626 {
    public static void main(String[] args) {
        // Spring Boot applications typically don't use a main method in controllers
    }

    @RequestMapping(path = "/users/{username}")
    @PreAuthorize("@yourSecurityService.isMyPage(authentication.principal, #username)")
    public void yourControllerMethod(@PathVariable String username) {
        // Implement your method logic here
    }
}