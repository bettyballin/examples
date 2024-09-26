import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp897 {
    public static void main(String[] args) {
        // Spring Boot application would be needed to run this controller
        // However, for this exercise, this main method is not necessary
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (session != null) {
            // Invalidate the current session
            session.invalidate();

            // Redirect to login page
            return "redirect:/login";
        }

        throw new IllegalStateException("Cannot logout without an active HTTP Session");
    }
}