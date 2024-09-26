import org.springframework.security.access.prepost.PreAuthorize;

public class Temp1402 {
    public static void main(String[] args) {
        Temp1402 temp = new Temp1402();
        Post post = new Post("This is a sample post text.");
        temp.checkAccess(post);
    }

    @PreAuthorize("(hasRole('ROLE_USER') and #post.text.length() <= 140) or hasRole('ROLE_PREMIUM')")
    public void checkAccess(Post post) {
        System.out.println("Access granted for post: " + post.getText());
    }
}

class Post {
    private String text;

    public Post(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}