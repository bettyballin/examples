import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class Temp53 {
    public static void main(String[] args) {
        // This main method is not needed for a Spring Boot application
    }

    @RequestMapping("/logoutUserBySessionId")
    public String logout(@RequestParam("sessionId") String sessionId) {
        // Log the current user out
        this.logoutUserBySessionId(sessionId);

        return "redirect:/";
    }

    private void logoutUserBySessionId(String sessionId) {
        // Implement logout logic here
        System.out.println("User with session ID " + sessionId + " logged out.");
    }
}