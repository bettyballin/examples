import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Temp2577 {

    private final HttpServletRequest request;

    public Temp2577(HttpServletRequest request) {
        this.request = request;
    }

    public static void main(String[] args) {
        // Spring Boot application should be run with SpringApplication.run()
        // This main method is not required for a Spring Boot controller
    }

    @GetMapping("/secure/xyz")
    public String securePage(Model model) {
        boolean loggedIn = this.isAuthenticated();
        model.addAttribute("loggedIn", loggedIn);
        return "securePage"; // Return the view name
    }

    private boolean isAuthenticated() {
        // Implement the authentication logic here
        return request.getUserPrincipal() != null;
    }
}