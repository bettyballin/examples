import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Temp2721 {

    @Autowired
    private PostService postService;

    @PreAuthorize("#userid == #user.id")
    @GetMapping("/update/{idpost}")
    public String showUpdateForm(
            @PathVariable int idpost,
            @ModelAttribute("post") Post post,
            @ModelAttribute("user") User user,
            @RequestParam("u") int userid,
            Model model) {

        post = postService.findById(idpost);
        model.addAttribute("post", post);
        return "_updateForm";
    }

    public static void main(String[] args) {
        // Spring Boot application entry point if needed
    }
}