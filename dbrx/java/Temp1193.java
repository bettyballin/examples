import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Temp1193 implements CommandLineRunner {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public static void main(String[] args) {
        SpringApplication.run(Temp1193.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Example usage
        long userId = 1; // replace with actual user ID
        List<AppRole> roles = findRolesByUserId(userId);
        roles.forEach(role -> System.out.println(role.getRoleName()));
    }

    // Find all roles for a specific user by ID
    public List<AppRole> findRolesByUserId(long userId) {
        return userRoleRepository.findByAppUser_Id(userId)
                .stream()
                .map(UserRole::getAppRole)
                .collect(Collectors.toList());
    }
}

// Other necessary classes and interfaces
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser_Id(long userId);
}

@Entity
@Table(name = "user_roles")
class UserRole {
    @Id
    private Long id;
    @ManyToOne
    private AppUser appUser;
    @ManyToOne
    private AppRole appRole;

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}

@Entity
@Table(name = "app_users")
class AppUser {
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

@Entity
@Table(name = "app_roles")
class AppRole {
    @Id
    private Long id;
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}