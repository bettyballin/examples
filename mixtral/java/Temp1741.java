import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public class Temp1741 {
    public static void main(String[] args) {
        // This is just a placeholder main method
        // To actually run this code, you would need to set up a Spring Boot application context.
    }
}

@Service
class UserService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository repository;

    public void saveUser(User user) {
        String rawPassword = user.getPassword();
        // encode the plain text password
        String encodedPassword = encoder.encode(rawPassword);

        user.setPassword(encodedPassword);

        repository.save(user);
    }
}

interface UserRepository {
    void save(User user);
}

class User {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}