import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class Temp566 implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Temp566.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Example usage
        String email = "example@example.com";
        Long totalBitcoins = userRepository.getTotalBitcoinsForEmail(email);
        System.out.println("Total Bitcoins for email " + email + ": " + totalBitcoins);
    }
}

@Repository
interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT SUM(u.bitcoin) FROM User u WHERE u.email = :email")
    Long getTotalBitcoinsForEmail(@Param("email") String email);
}

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private Long bitcoin;

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

    public Long getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(Long bitcoin) {
        this.bitcoin = bitcoin;
    }
}