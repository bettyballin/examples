import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post")
public class PostController {

    @RequestMapping(value= {"/{post}"})
    public ModelAndView postPage(@AuthenticationPrincipal User tempUser, @PathVariable("post") String tempPostName ) throws NotFoundException  {
        // Your code here
        return new ModelAndView("postPage");
    }

    @PostMapping("addcomment")
    @ResponseBody
    public String saveComment(@AuthenticationPrincipal User tempUser, @RequestParam("post_id") int id, @RequestParam("comment") String tempComment) {
        // Your code here
        return "Comment saved";
    }       
}

// Placeholder for User class
class User {
    // Define user properties and methods here
}

// Placeholder for NotFoundException class
class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }
}