import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User3Details;
import javax.persistence.*;
import java.util.Optional;

@Entity
public class User3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields and their mappings

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    // Getters and setters
}

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User3 user;

    private String firstname;

    // Getters and setters
}

public interface User3Repository extends JpaRepository<User3, Long> {
    Optional<User3> findByUser3name(String username);
}

public class CustomUser3Details implements User3Details {
    private User3 user;

    public CustomUser3Details(User3 user) {
        this.user = user;
    }

    // Implement User3Details methods using user field
    // Example:
    // @Override
    // public String getUser3name() {
    //     return user.getUser3name();
    // }
}