import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public class Temp1491 {
    public static void main(String[] args) {
        // Your main method implementation here
    }
    
    public interface UserRepository extends JpaRepository<User, Long> {
        List<User> findByEmail(String email);

        @Query("SELECT SUM(u.bitcoin) FROM User u WHERE u.email = ?1")
        Long sumBitcoinBySameEmail(String email);
    }

    @Entity
    public static class User {
        @Id
        private Long id;
        private String email;
        private int bitcoin;

        // Getters and Setters

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

        public int getBitcoin() {
            return bitcoin;
        }

        public void setBitcoin(int bitcoin) {
            this.bitcoin = bitcoin;
        }
    }
}