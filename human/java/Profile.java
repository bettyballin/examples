import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String providerId;
    public String authUserId;
    public String firstName;
    public String lastName;
    public String fullName;
    public String email;
    public String avatarUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    public Profile(BasicProfile profile) {
        this.providerId = profile.providerId();
        this.authUserId = profile.userId();
        this.firstName = profile.firstName().orElse(null);
        this.lastName = profile.lastName().orElse(null);
        this.fullName = profile.fullName().orElse(null);
        this.email = profile.email().orElse(null);
        this.avatarUrl = profile.avatarUrl().orElse(null);
    }
}

// Dummy BasicProfile class to make the code compile
class BasicProfile {
    public String providerId() {
        return "dummyProviderId";
    }

    public String userId() {
        return "dummyUserId";
    }

    public java.util.Optional<String> firstName() {
        return java.util.Optional.of("dummyFirstName");
    }

    public java.util.Optional<String> lastName() {
        return java.util.Optional.of("dummyLastName");
    }

    public java.util.Optional<String> fullName() {
        return java.util.Optional.of("dummyFullName");
    }

    public java.util.Optional<String> email() {
        return java.util.Optional.of("dummyEmail");
    }

    public java.util.Optional<String> avatarUrl() {
        return java.util.Optional.of("dummyAvatarUrl");
    }
}

// Dummy User class to make the code compile
class User extends Model {
}

// Dummy Model class to make the code compile
class Model {
}