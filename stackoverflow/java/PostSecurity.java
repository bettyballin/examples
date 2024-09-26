import org.springframework.security.access.prepost.PreAuthorize;

public class PostSecurity {

    @PreAuthorize("(hasRole('ROLE_USER') and #post.text.length() <= 140) or hasRole('ROLE_PREMIUM')")
    public void createPost(Post post) {
        // method implementation
    }
}

class Post {
    String text;
    // getters, setters, and other properties/methods
}