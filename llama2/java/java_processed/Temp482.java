import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

public class Temp482 {
    public static void main(String[] args) {
        // Application entry point
    }
}

@Entity
class Task {
    @Id
    private Long id;
    private String userId;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

@Repository
interface TaskRepository extends JpaRepository<Task, Long> {

}

public class TaskListener {
    @PrePersist
    public void updateUserId(Task task) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            String principalName = auth.getName();
            task.setUserId(principalName);
        }
    }
}