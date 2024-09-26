import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Temp1159 {

    @RequestMapping("/registration")
    public String showRegistrationForm(@ModelAttribute("user") User user, HttpSession httpSession, Model model) {
        Object obj = httpSession.getAttribute("failedUser");

        if (obj != null && obj.toString().trim().length() > 0) {
            // Pre-populate the username field
            user.setUsername(obj.toString());
        }

        model.addAttribute("user", user);
        return "registration";
    }

    public static void main(String[] args) {
        // This main method is just a placeholder and won't actually run the Spring application.
        // Spring applications are typically run using Spring Boot or a servlet container.
    }
}

class User {
    private String username;
    private String password;

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}