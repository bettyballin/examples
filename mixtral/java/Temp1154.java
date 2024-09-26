import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

// Define the User class
class User {
    private Long id;
    private String name;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public interface SecuredUserRepo extends CrudRepository<User, Long> {}

@Service
class UserManagementService {

  private final SecuredUserRepo repo;

  @Autowired
  public UserManagementService(SecuredUserRepo repo) {
    this.repo = repo;
  }

  // Add your methods here for managing users
}