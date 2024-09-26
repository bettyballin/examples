import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final Random random;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
        this.random = new SecureRandom();
    }

    public void createUser(String username, String password) throws Exception {
        byte[] salt = generateSalt();

        User user = new User(username);
        user.setPassword(passwordEncoder().encode(password + new String(salt)));
        user.setSalt(Base64.getEncoder().encodeToString(salt));

        userMapper.insertUser(user);
    }

    private byte[] generateSalt() {
        return random.generateSeed(16); // Generate a 128-bit salt
    }

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

// Assuming User and UserMapper classes are defined as follows:

class User {
    private String username;
    private String password;
    private String salt;

    public User(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}

interface UserMapper {
    void insertUser(User user);
}