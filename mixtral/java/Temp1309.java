import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class Temp1309 {

    private final BlogService blogService;

    public Temp1309(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog/save")
    public String blogSavePost(@AuthenticationPrincipal CurrentUser currentUser, BlogForm blogForm) {
        Long userId = currentUser.getId();

        // Create or update a post with user's ID
        if (blogForm.getBlogId() != null && !Objects.equals(userId, blogService.findById(blogForm.getBlogId()).orElseThrow().getUserId())) {
            throw new AccessDeniedException("Unauthorized access to this post");
        }

        Blog savedPost = blogService.saveOrUpdate(currentUser, userId, blogForm);

        return "redirect:/blog";
    }

    public static void main(String[] args) {
        // Your application start logic here
    }
}

// Dummy classes to make the code compile
class BlogService {
    public Blog saveOrUpdate(CurrentUser currentUser, Long userId, BlogForm blogForm) {
        // Implementation here
        return new Blog();
    }

    public java.util.Optional<Blog> findById(Long blogId) {
        // Implementation here
        return java.util.Optional.empty();
    }
}

class CurrentUser {
    public Long getId() {
        // Implementation here
        return 1L;
    }
}

class BlogForm {
    public Long getBlogId() {
        // Implementation here
        return 1L;
    }
}

class Blog {
}