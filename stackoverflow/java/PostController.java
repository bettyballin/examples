import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping(method = RequestMethod.PUT, value = "posts/{id}")
    public void updatePost(@PathVariable("id") Long postId, HttpServletRequest request) {
        // Fetch the authenticated user name
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        Object principal = authentication.getPrincipal();
        String username = null;

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }

        // Make a database call to verify if the user is owner of the post
        Post post = postRepository.getPostByUserNameAndId(username, postId);

        if (post == null && !request.isUserInRole("ADMIN")) {
            // return 403 error code
            // This would usually be implemented by throwing an exception
            // e.g., throw new AccessDeniedException("You do not have permission to edit this post.");
        }

        // proceed with the update
        // Code for updating the post would go here
    }
}