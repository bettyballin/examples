import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

// Assuming a User class exists
@Entity
public class User {
    @Id
    private Long id;
    private String name;

    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

@Entity
public class Employer {
    @Id
    private Long id;

    @OneToOne
    private User user;

    // employer specific properties

    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}

@Entity
public class Employee {
    @Id
    private Long id;

    @OneToOne
    private User user;

    // employee specific properties

    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}