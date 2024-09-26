import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.security.Principal;

@Controller
public class Temp1824 {

    @Autowired
    private PostService postService;

    @GetMapping("/update/{idpost}")
    public String showUpdateForm(
            @PathVariable int idpost,
            Principal principal,
            Model model) {

        Post post = postService.findById(idpost);

        // Check if the current user is authorized to update this post
        User loggedInUser = (User) ((Authentication) principal).getPrincipal();

        if (!loggedInUser.getUsername().equals(post.getUserId())) {
            throw new AccessDeniedException("You are not allowed to access this resource!");
        }

        model.addAttribute("post", post);

        return "_updateForm";
    }

    public static void main(String[] args) {
        // This is a Spring Boot application, main method can be used to launch the application
        SpringApplication.run(Temp1824.class, args);
    }
}