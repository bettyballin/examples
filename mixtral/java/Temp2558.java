import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp2558 {
    public static void main(String[] args) {
        String password = "yourPasswordHere";
        String hashedPassword = new BCryptPasswordEncoder().encode(password);
        // Store 'hashedPassword' in your database
        System.out.println("Hashed Password: " + hashedPassword);
    }
}