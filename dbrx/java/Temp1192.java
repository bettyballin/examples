import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
@Table(name = "user_roles")
class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;
    
    // getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}

public class Temp1192 {
    public static void main(String[] args) {
        // Application entry point
    }

    public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
        List<UserRole> findByAppUser_Id(long userId);
    }
}