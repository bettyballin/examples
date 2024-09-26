import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Entity
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    // Constructors, getters, setters, etc.
    public Role() {}
    
    public Role(String authority) {
        this.authority = authority;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getAuthority() {
        return authority;
    }
    
    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    // Constructors, getters, setters, etc.
    public User() {}
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}

@Entity
class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    // Constructors, getters, setters, etc.
    public UserRole() {}
    
    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }
    
    public Long getId() {
        return id;
    }
    
    public User getUser() {
        return user;
    }
    
    public Role getRole() {
        return role;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
}

public class BootStrap {

    @PersistenceContext
    private EntityManager entityManager;

    public void init() {
        addTestUsers();
    }

    @Transactional
    void addTestUsers() {
        Role adminRole = new Role("ROLE_ADMIN");
        entityManager.persist(adminRole);

        User testUser = new User("me", "password");
        entityManager.persist(testUser);

        UserRole userRole = new UserRole(testUser, adminRole);
        entityManager.persist(userRole);

        entityManager.flush();
        entityManager.clear();

        assert entityManager.createQuery("SELECT COUNT(u) FROM User u", Long.class).getSingleResult() == 1;
        assert entityManager.createQuery("SELECT COUNT(r) FROM Role r", Long.class).getSingleResult() == 1;
        assert entityManager.createQuery("SELECT COUNT(ur) FROM UserRole ur", Long.class).getSingleResult() == 1;
    }

    public static void main(String[] args) {
        // Assuming you have a Spring context or some way to initialize the EntityManager
        BootStrap bootStrap = new BootStrap();
        bootStrap.init();
    }
}