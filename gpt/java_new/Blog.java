import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Blog {
    // ... other fields ...

    @ManyToOne
    @JoinColumn(name = "user_id") // assuming there is a 'user_id' column in 'blog' table
    private User user;

    // Getters and setters for 'user'
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // ... other getters and setters ...
}

// Assuming this is within a class
public void saveBlogPost(CurrentUser currentUser, BlogForm blogForm) {
    Blog blog = new Blog();
    // ... set blog properties from blogForm ...

    User user = userRepository.findByUsername(currentUser.getUsername());
    blog.setUser(user);

    blogRepository.save(blog);
}