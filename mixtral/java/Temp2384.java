import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Temp2384 {
    public static void main(String[] args) {
        // Spring Boot application would start here if this was a complete Spring Boot application
    }

    @GetMapping("/centerPoint")
    public void centerPoint(@ModelAttribute("token") ExpiringUsernameAuthenticationToken token,
                            HttpServletResponse response) throws IOException {
        // ...rest of code omitted for brevity
    }
}

// Dummy class to make the code compilable
class ExpiringUsernameAuthenticationToken {
    // Implementation omitted for brevity
}