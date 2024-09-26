import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController1 {

    private final PostService postService;

    public PostController1(PostService postService) {
        this.postService = postService;
    }

    @PreAuthorize("#userid == #user.id")
    @GetMapping("/update/{idpost}")
    public String showUpdateForm(
            @PathVariable("idpost") int idpost,
            @RequestParam("u") int userid,
            Model model) {

        Post post = postService.findById(idpost);
        model.addAttribute("post", post);
        return "_updateForm";
    }
    
    // Assuming PostService and Post classes are defined elsewhere.
}