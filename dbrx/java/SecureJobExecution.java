import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
class JobExecution {
    // Assuming this class contains some implementation
}

@Entity
class User {
    // Assuming this class contains some implementation
}

@Entity
public class SecureJobExecution extends JobExecution {
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public SecureJobExecution() {}

    public SecureJobExecution(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}