import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController1 {

    @GetMapping("/mainPage")
    public String mainPage(HttpServletRequest request) {
        if (request.getSession(false) != null) {
            Teacher t = (Teacher) request.getSession().getAttribute("teacher");
            // Your logic to validate can come here
            if (t == null) {
                return "You are not logged in!";
            }
            // If validation passes, proceed with the main page logic
        } else {
            return "You are not logged in!";
        }
        return "mainPage";
    }
    
    // Dummy Teacher class for compilation purpose
    class Teacher {
        // Teacher properties and methods
    }
}