import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public class Temp3307 {
    public static void main(String[] args) {
        // Your logic here
    }

    public interface UserRepository extends JpaRepository<User, Long> {
        List<User> findByEmail(String email);
    }
}

class User {
    private Long id;
    private String email;
    
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}