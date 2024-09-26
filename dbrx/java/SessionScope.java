import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages = {"com.sencerseven.blog.admin", "com.sencerseven.blog.controller"})
public class SessionScope {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return userService.getByEmail(authentication.getName());
        }
        return null;
    }
}

@Controller
@RequestMapping("/post")
public class PostController {

    // ...

    @RequestMapping(value = {"/{post}"})
    public ModelAndView postPage(@PathVariable("post") String tempPostName, @ModelAttribute("user") User user) throws NotFoundException {
        // ...
        return new ModelAndView("postPage");
    }

    @PostMapping("addcomment")
    @ResponseBody
    public String saveComment(@RequestParam("post_id") int id, @RequestParam("comment") String tempComment, @ModelAttribute("user") User user) {
        // ...
        return "Comment saved";
    }
}