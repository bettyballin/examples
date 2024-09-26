import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp1934 {

    public static void main(String[] args) {
        User user = new User("myPassword"); // Assuming User class has a constructor that accepts password
        String encodedPassword = passwordEncoder().encode(user.getPassword());
        System.out.println("Encoded Password: " + encodedPassword);
        // Save `encodedPassword` instead of raw password
    }

    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

class User {
    private String password;

    public User(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}