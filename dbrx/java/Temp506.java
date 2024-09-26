import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public class Temp506 {
    public static void main(String[] args) {
        // Your main application logic here
    }
}

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    public Account findByUsername(String username);
}

public class Account {
    private Long id;
    private String username;

    // Constructors, getters, and setters
    public Account() {}

    public Account(Long id, String username) {
        this.id = id;
        this.username = username;
    }

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