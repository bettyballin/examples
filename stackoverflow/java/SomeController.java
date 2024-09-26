import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SomeController {

    @RequestMapping("/somePath")
    public ModelAndView someRequestHandler(User activeUser) {
       // ... add your code logic here
       return new ModelAndView("viewName"); // replace "viewName" with the actual view name
    }
    
    // Assuming ActiveUser is a custom annotation that you've created for injecting the active user
    public @interface ActiveUser {
    }
    
    public class User {
        // User class fields and methods here
    }
}