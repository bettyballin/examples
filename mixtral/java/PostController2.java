import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

// Entity class for Post
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String createdBy;
    private String content;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

// Repository interface
@Repository
public interface CustomPostRepo extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE (p.createdBy = ?#{principal?.username} OR hasRole('ROLE_ADMIN')) AND id=?1")
    Optional<Post> findByIdAndUserOrAdmin(Long postId);

    // Add other custom methods as needed
}

// Controller class
@RestController
@RequestMapping("/posts")
public class PostController {

    private final CustomPostRepo postRepo;

    @Autowired
    public PostController(CustomPostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Post> getAll() {
        return postRepo.findAll();
    }
}

// Main application class
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}