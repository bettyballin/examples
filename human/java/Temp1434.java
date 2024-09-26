import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

public class Temp1434 {

    // Assuming a PostRepository is available for fetching the post
    private PostRepository postRepository;

    public Temp1434(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping(method = {RequestMethod.PUT}, value = {"posts/{id}"})
    public void updatePost(@PathVariable("id") Long id, HttpServletRequest request) {
        // Fetch the authenticated user name
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        Object principal = authentication.getPrincipal();
        String username = null;

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }

        // Make a database call to verify if the user is owner of the post
        Post post = postRepository.getPostByUserName(username, id);

        if (post == null && !request.isUserInRole("ADMIN")) {
            // return 403 error code
            throw new SecurityException("Unauthorized to update this post");
        }

        // proceed with the update
        // code to update the post
    }
}

// Assuming a Post class
class Post {
    private Long id;
    private String content;
    private String username;

    // getters and setters
}

// Assuming a PostRepository interface
interface PostRepository {
    Post getPostByUserName(String username, Long id);
}