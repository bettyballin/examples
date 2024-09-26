import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
class APPUser {
    @Id
    private Long id;
    private String username;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
    private java.util.List<APPUserRole> appuserroles;

    // Getters and setters omitted for brevity
}

@Entity
class APPUserRole {
    @Id
    private Long id;
    private String roleName;

    @ManyToOne
    private APPUser appUser;

    // Getters and setters omitted for brevity
}

@Repository
class APPUserRepository {
    @Autowired
    private EntityManager entityManager;

    public Optional<APPUser> findUserWithRolesByUsername(String username) {
        TypedQuery<APPUser> query = entityManager.createQuery(
            "SELECT u FROM APPUser u LEFT JOIN FETCH u.appuserroles WHERE u.username = :username",
            APPUser.class
        );
        query.setParameter("username", username);
        return Optional.ofNullable(query.getSingleResult());
    }
}

public class Temp3674 {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("example-unit").createEntityManager();
        APPUserRepository userRepository = new APPUserRepository();
        userRepository.entityManager = entityManager;

        String username = "exampleUser";
        Optional<APPUser> userOptional = userRepository.findUserWithRolesByUsername(username);

        if (userOptional.isPresent()) {
            APPUser user = userOptional.get();
            System.out.println("User found: " + user.getUsername());
        } else {
            System.out.println("User not found");
        }
    }
}