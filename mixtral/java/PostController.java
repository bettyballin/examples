import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private HttpSession session;

    // This method will be called for every request
    public User getUserFromSession(HttpServletRequest httpServletRequest) throws Exception {
        return (User) httpServletRequest.getAttribute("user");
    }

    @GetMapping("/{post}")
    public ModelAndView postPage(@PathVariable String post, HttpServletRequest request) throws Exception {
        User user = getUserFromSession(request);

        // Your code here

        return new ModelAndView("your_view");
    }

    @PostMapping("/addcomment")
    public @ResponseBody String saveComment(@RequestParam int id,
                                            @RequestParam String comment,
                                            HttpServletRequest request) throws Exception {

        User user = getUserFromSession(request);

        // Your code here

        return "success";
    }
}