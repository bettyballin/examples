import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping("/mainPage")
    public String mainPage(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            Teacher t = (Teacher) session.getAttribute("teacher");
            // Your logic to validate can come here
            return "mainPage";
        } else {
            return "notLoggedIn"; // You can return a different view or message indicating the user is not logged in
        }
    }
}

// Assuming that Teacher is a class in your project
class Teacher {
    // Teacher class implementation
}