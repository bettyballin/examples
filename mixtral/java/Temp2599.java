import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

@Entity
class Role {
    @Id
    private Long id;
    private String name;

    // getters and setters
}

@Entity
class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    // getters and setters
}

public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User findByIdWithRoles(Long id) {
        User user = entityManager.find(User.class, id);

        // Initialize roles collection
        Hibernate.initialize(user.getRoles());

        return user;
    }
}