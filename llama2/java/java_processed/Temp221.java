import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Temp221 {
    public static void main(String[] args) {
        SpringApplication.run(Temp221.class, args);
    }
}

interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
}

interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByName(String name);
}

@Entity
class User {
    @Id
    private Long id;
    private String username;

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

@Entity
class Role {
    @Id
    private Long id;
    private String name;

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