import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yourpackage.SecurityUser; // Replace with your actual package path for SecurityUser

@Repository
public interface UserRepository1 extends JpaRepository<SecurityUser, Long> {
    SecurityUser findByUsername(String username);
}