import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String providerId;
    private String authUserId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String avatarUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Profile1() {}

    // Getters and setters for all fields

    // Example of getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Other getters and setters...
}