import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.PrePersist;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Temp481 {
    public static void main(String[] args) {
        // Application entry point
    }
}

@Entity
class Task {
    @Id
    private Long id;
    private Long userId;

    // Constructors, getters, and setters
    public Task() {}

    public Task(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @PrePersist
    public void updateUserId() {
        // Logic to update userId before persisting
    }
}

@Repository
interface TaskRepository extends JpaRepository<Task, Long> {
    // Additional query methods if needed
}