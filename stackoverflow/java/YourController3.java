import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YourController3 {

    @GetMapping("/")
    public void get(@AuthenticationPrincipal User user) {
        // ...
    }
}