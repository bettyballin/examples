import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Entity class
class Media {
    private Long id;
    private String title;
    private String url;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}

// Repository Interface
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Repository
public interface CustomMediaRepo extends CrudRepository<Media, Long> {
    // Your custom methods here
}

// Controller class
@RestController
@RequestMapping("/media")
public class MediaController {

    private final CustomMediaRepo mediaRepo;

    @Autowired
    public MediaController(CustomMediaRepo mediaRepo) {
        this.mediaRepo = mediaRepo;
    }

    @GetMapping
    public List<Media> getAll() {
        return (List<Media>) mediaRepo.findAll();
    }

    // Add other methods as needed
}

// Main application class
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MediaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MediaApplication.class, args);
    }
}