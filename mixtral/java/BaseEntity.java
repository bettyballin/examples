import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@MappedSuperclass
public abstract class BaseEntity {
    // other properties

    private String userId;

    @PrePersist
    public void prePersist() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            this.userId = ((User) authentication.getPrincipal()).getId();
        }
    }

    // Getters and Setters for userId
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Other abstract methods or properties
}

// Assuming a User class exists
class User {
    private String id;

    // Constructor, Getters and Setters
    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}