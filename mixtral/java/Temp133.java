import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp133 {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String password = "myPassword123";
        String hashedPassword = bCrypt.encode(password);

        // To verify the password
        boolean isValid = bCrypt.matches("myPassword123", hashedPassword);

        System.out.println("Hashed Password: " + hashedPassword);
        System.out.println("Password is valid: " + isValid);
    }
}