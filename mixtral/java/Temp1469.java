import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Temp1469 {

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @AllowedForSystemUsers(roles = {"ROLE_ADMIN", "ROLE_USER"})
    public String searchRoom(@ModelAttribute Booking booking, Model model, long type) {
        // do something
        return "searchResult";
    }

    public static void main(String[] args) {
        // Spring Boot application would typically be run here, but main method isn't used in this context
    }
}

class Booking {
    // Assume this class has required fields and methods
}

class Model {
    // Assume this class has required fields and methods
}

@interface AllowedForSystemUsers {
    String[] roles();
}