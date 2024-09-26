import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping("/mainPage")
    public String mainPage(HttpSession session) {
        Object teacher = session.getAttribute("teacher");
        return (teacher != null) ? "mainPage" : "notLoggedIn";
    }
}

No changes needed, the code already compiles without errors. 

However, in a real-world scenario, you might want to handle potential exceptions and also ensure that the necessary dependencies are included in the project. Here's a more robust version:


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping("/mainPage")
    public String mainPage(HttpSession session) {
        try {
            Object teacher = session.getAttribute("teacher");
            return (teacher != null) ? "mainPage" : "notLoggedIn";
        } catch (Exception e) {
            // Handle the exception as needed
            return "errorPage";
        }
    }
}