import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public class Temp2263 {
    public static void main(String[] args) {
        // Main method logic here (if any)
    }
}

@Repository
interface UserRepository extends JpaRepository<SecurityUser, Long> {
    SecurityUser findByUsername(String username);
}

class SecurityUser {
    private Long id;
    private String username;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}