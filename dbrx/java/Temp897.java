import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Temp897 {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/blog/edit/{id}")
    public String blogEditPost(@PathVariable Long id, @AuthenticationPrincipal CurrentUser currentUser, BlogForm blogForm) {
        Optional<Blog> optional = blogRepository.findById(id);
        if (optional.isPresent() && canAccessBlog(currentUser, optional.get())) {
            // ...
            return "Success";
        }
        return "Failure";
    }

    private boolean canAccessBlog(CurrentUser user, Blog blog) {
        return userRepository.findByUsername(user.getUsername())
                .map(User::getId)
                .orElse(-1L).equals(blog.getUserId());
    }
}

// Assuming these classes exist.
class CurrentUser {
    private String username;

    public CurrentUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

class Blog {
    private Long userId;

    public Blog(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}

class BlogForm {
    // Form fields and methods.
}

interface BlogRepository {
    Optional<Blog> findById(Long id);
}

interface UserRepository {
    Optional<User> findByUsername(String username);
}

class User {
    private Long id;

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}