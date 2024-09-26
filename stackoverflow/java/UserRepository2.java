import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository2 extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);
}